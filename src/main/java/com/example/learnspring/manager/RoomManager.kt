package com.example.learnspring.manager

import com.example.learnspring.bean.RoomBean

object RoomManager {
    private val roomMap = mutableMapOf<String, RoomBean>()


    fun addRoom(roomBean: RoomBean) {
        roomMap[roomBean.roomId] = roomBean
    }

    fun removeRoom(roomId: String) {
        getRoom(roomId)?.let {
            it.contactList.clear()
            roomMap.remove(roomId)
        }
    }

    fun getRoom(roomId: String): RoomBean? {
        return roomMap[roomId]
    }

    fun getAllRoomList(): MutableList<RoomBean> {
        return roomMap.map {
            it.value
        }.toMutableList()
    }

    fun getRoomTotalCount():Int{
        return roomMap.size
    }

}