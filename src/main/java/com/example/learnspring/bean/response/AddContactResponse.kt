package com.example.learnspring.bean.response

import com.example.learnspring.bean.Contact
import com.example.learnspring.constant.ResponseType


class AddContactResponse(toAccount:String,contact: Contact) : BaseResponse(ResponseType.ADD_CONTACT,toAccount=toAccount,data = contact) {
}