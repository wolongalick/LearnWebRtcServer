package com.example.learnspring

import com.example.learnspring.bean.Contact
import com.example.learnspring.bean.RoomBean
import com.example.learnspring.bean.request.BaseRequest
import com.example.learnspring.bean.request.CreateRoomRequest
import com.example.learnspring.bean.response.*
import com.example.learnspring.constant.RequestType
import com.example.learnspring.manager.ContactManager
import com.example.learnspring.manager.MessageManager
import com.example.learnspring.manager.RoomManager
import com.example.learnspring.manager.SessionManager
import com.example.learnspring.utils.JsonUtils
import javax.websocket.server.ServerEndpoint
import javax.websocket.OnOpen
import javax.websocket.server.PathParam
import javax.websocket.OnClose
import javax.websocket.OnMessage
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.websocket.Session

@ServerEndpoint("/webSocket/{account}")
@Component
class WebSocketServer {

    companion object {
        private val LOG = LoggerFactory.getLogger(WebSocketServer::class.java)
    }

    private var account: String? = null

    // 用户userId登录进来
    @OnOpen
    fun onOpen(session: Session?, @PathParam("account") account: String) {
        this.account = account
        println("$account-->onOpen......,account:$account")
        SessionManager.addSession(account, session!!)
        val newContact = Contact(account)
        ContactManager.addContact(account, newContact)

        SessionManager.sessionMap.forEach {
            MessageManager.send(AddContactResponse(it.key, newContact))
        }
    }

    // 用户下线
    @OnClose
    fun onClose() {
        println("$account-->onClose......")
        // 根据用户名查出房间,
        account?.let { it ->
            SessionManager.removeSession(it)
            SessionManager.sessionMap.forEach { entry ->
                MessageManager.send(RemoveContactResponse(entry.key, ContactManager.getContact(it)!!))
            }
        }

    }

    @OnMessage
    fun onMessage(message: String, session: Session) {
        handleMessage(message, session)
    }

    // 处理各种消息
    private fun handleMessage(message: String, session: Session) {
        val baseRequest = JsonUtils.parseJson2Bean(message, BaseRequest::class.java)
        val msgType = baseRequest.msgType
        println("服务器接收的消息,msgType:$msgType,:$message")
        when (msgType) {
            RequestType.All_CONTACT -> {
                val list = mutableListOf<Contact>()
                SessionManager.sessionMap.forEach { entry ->
                    ContactManager.getContact(entry.key)?.apply {
                        list.add(this)
                    }
                }
                MessageManager.send(AllContactResponse(baseRequest.fromAccount, list))
            }
            RequestType.SEND_SDP -> {

            }
            RequestType.CREATE -> {
                val createRoomRequest = JsonUtils.parseJson2Bean(message, CreateRoomRequest::class.java)
                val roomBean = RoomBean(createRoomRequest.roomId, createRoomRequest.fromAccount)
                roomBean.contactList.add(Contact(createRoomRequest.fromAccount))
                roomBean.roomSize = 1
                roomBean.roomName = "第${RoomManager.getRoomTotalCount() + 1}个房间"
                RoomManager.addRoom(roomBean)
                val response = CreateRoomResponse(createRoomRequest.roomId, createRoomRequest.fromAccount, roomBean)
                MessageManager.send(response)
            }
            RequestType.INVITE -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.CANCEL -> {
                RoomManager.removeRoom(baseRequest.roomId)
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.RING -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.REJECT -> {
                RoomManager.removeRoom(baseRequest.roomId)
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.JOIN -> {
                val roomBean = RoomManager.getRoom(baseRequest.roomId)
                roomBean?.contactList?.let {
                    if (!it.contains(Contact(baseRequest.fromAccount))) {
                        it.add(Contact(baseRequest.fromAccount))//此时的fromAccount指的是被叫方,因为是JOIN只能是被叫方发来的消息
                    }
                }

                //将被叫方加入房间成功的消息,分别发送给主叫方和被叫方
                val joinSuccessResponseMsg = JsonUtils.parseBean2json(
                    JoinSuccessResponse(
                        baseRequest.roomId,
                        baseRequest.toAccount,
                        baseRequest.fromAccount
                    )
                )
                MessageManager.send(baseRequest.fromAccount, msgType, joinSuccessResponseMsg)//给被叫方发消息
                MessageManager.send(baseRequest.toAccount, msgType, joinSuccessResponseMsg)//给主叫方发消息
            }
            RequestType.SDP_OFFER -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.SDP_ANSWER -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.CANDIDATE -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.REMOVE_CANDIDATES -> {
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
            RequestType.LEAVE -> {
                RoomManager.removeRoom(baseRequest.roomId)
                MessageManager.send(baseRequest.toAccount, msgType, message)
            }
        }
    }


}