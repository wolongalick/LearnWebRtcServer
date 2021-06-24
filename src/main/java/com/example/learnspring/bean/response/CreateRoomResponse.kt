package com.example.learnspring.bean.response

import com.example.learnspring.bean.RoomBean
import com.example.learnspring.constant.ResponseType

class CreateRoomResponse(roomId:String,toAccount:String,roomBean:RoomBean) : BaseResponse(ResponseType.CREATE_SUCCESS,roomId=roomId,toAccount=toAccount,data = roomBean){
}