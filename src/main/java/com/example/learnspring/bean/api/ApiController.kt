package com.example.learnspring.bean.api

import com.example.learnspring.manager.ContactManager
import com.example.learnspring.manager.RoomManager
import com.example.learnspring.utils.JsonUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author 崔兴旺
 * @description
 * @date 2021/6/27 12:11
 */
@RestController
@RequestMapping("/api")
class ApiController {

    @RequestMapping(value = ["get-room-list"], produces = ["application/json;charset=UTF-8"])
    fun getRoomList(): String {
        return JsonUtils.parseBean2json(AllRoomListResponse(RoomManager.getAllRoomList()))
    }

}