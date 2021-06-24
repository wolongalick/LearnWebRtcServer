package com.example.learnspring.manager

import javax.websocket.Session

object SessionManager {

    val sessionMap: LinkedHashMap<String, Session> = LinkedHashMap()

    fun addSession(account: String, session: Session) {
        sessionMap.put(account, session)
    }

    fun removeSession(account: String) {
        sessionMap.remove(account)
    }

    fun getSession(account: String): Session? {
        return sessionMap[account]
    }


}