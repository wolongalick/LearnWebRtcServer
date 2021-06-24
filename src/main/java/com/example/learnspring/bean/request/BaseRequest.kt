package com.example.learnspring.bean.request


open class BaseRequest<Data>(val msgType: String="", val roomId:String="",val fromAccount: String,val toAccount: String = "", val data: Data? = null)