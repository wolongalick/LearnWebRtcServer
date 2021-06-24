package com.example.learnspring.bean.response

import com.example.learnspring.bean.Contact
import com.example.learnspring.constant.ResponseType

class AllContactResponse(toAccount:String, list: MutableList<Contact>) : BaseResponse(ResponseType.ALL_CONTACT,toAccount=toAccount,data = list)