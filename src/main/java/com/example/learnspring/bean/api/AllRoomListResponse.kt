package com.example.learnspring.bean.api

import com.example.learnspring.bean.RoomBean
import com.example.learnspring.bean.api.base.BaseApiResponse

/**
 * @author 崔兴旺
 * @description
 * @date 2021/6/27 12:16
 */
class AllRoomListResponse(data: MutableList<RoomBean>) : BaseApiResponse<MutableList<RoomBean>>(data) {
}