package com.example.learnspring.bean.response

import com.example.learnspring.constant.ResponseType

class JoinSuccessResponse(roomId: String, fromAccount: String, toAccount: String) :
    BaseResponse(ResponseType.JOIN_SUCCESS, roomId, fromAccount, toAccount) {
}