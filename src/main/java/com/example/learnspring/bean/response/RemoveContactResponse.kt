package com.example.learnspring.bean.response

import com.example.learnspring.bean.Contact
import com.example.learnspring.constant.ResponseType

class RemoveContactResponse(toAccount: String, contact: Contact) : BaseResponse(ResponseType.REMOVE_CONTACT, toAccount = toAccount, data = contact)