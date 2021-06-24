package com.example.learnspring.bean

data class ResponseMsgBean(
    val msgType: String,
    val contact: Contact,
    val allContactList: MutableList<Contact>
)

