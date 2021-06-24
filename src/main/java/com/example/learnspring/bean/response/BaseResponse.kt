package com.example.learnspring.bean.response

open class BaseResponse(val msgType: String,val roomId:String="", val fromAccount: String = "", val toAccount: String, val data: Any? = null) {

}