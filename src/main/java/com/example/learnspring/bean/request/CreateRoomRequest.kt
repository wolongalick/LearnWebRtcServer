package com.example.learnspring.bean.request

class CreateRoomRequest(msgType: String = "", roomId: String = "", fromAccount: String, toAccount: String = "", data: Any? = null) : BaseRequest<Any>(msgType, roomId, fromAccount, toAccount, data)