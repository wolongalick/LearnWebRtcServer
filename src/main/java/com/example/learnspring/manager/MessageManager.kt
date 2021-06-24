package com.example.learnspring.manager

import com.example.learnspring.bean.response.BaseResponse
import com.example.learnspring.utils.JsonUtils

object MessageManager {
    fun send(response: BaseResponse) {
        val json = JsonUtils.parseBean2json(response)
        println("服务器给${response.toAccount}发送的消息,msgType:${response.msgType},内容:${json}")
        SessionManager.getSession(response.toAccount)?.asyncRemote?.sendText(json)
    }
    fun send(toAccount:String,msgType:String,json: String) {
        println("服务器给${toAccount}发送的消息,msgType:${msgType},内容:${json}")
        SessionManager.getSession(toAccount)?.asyncRemote?.sendText(json)
    }
}