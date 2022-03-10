package com.example.learnspring.constant

class RequestType {
    companion object {
        const val All_CONTACT: String = "All_CONTACT"
        const val SEND_SDP: String = "SEND_SDP"

        const val CREATE: String = "CREATE"
        const val INVITE: String = "INVITE"
        const val CANCEL: String = "CANCEL"
        const val JOIN: String = "JOIN"
        const val RING: String = "RING"
        const val REJECT: String = "REJECT"
        const val SDP_OFFER: String = "SDP_OFFER"
        const val SDP_ANSWER: String = "SDP_ANSWER"
        const val CANDIDATE: String = "CANDIDATE"
        const val REMOVE_CANDIDATES: String = "REMOVE_CANDIDATES"
        const val LEAVE: String = "LEAVE"
    }
}

class ResponseType {
    companion object {
        const val ALL_CONTACT: String = "ALL_CONTACT"
        const val ADD_CONTACT: String = "ADD_CONTACT"
        const val REMOVE_CONTACT: String = "REMOVE_CONTACT"
        const val CREATE_SUCCESS: String = "CREATE_SUCCESS"
        const val PEERS: String = "PEERS"
        const val INVITE: String = "INVITE"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val CANCEL: String = "CANCEL"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val RING: String = "RING"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val REJECT: String = "REJECT"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val JOIN_SUCCESS: String = "JOIN_SUCCESS"
        const val SDP_OFFER: String = "SDP_OFFER"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val SDP_ANSWER: String = "SDP_ANSWER"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val CANDIDATE: String = "CANDIDATE"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val REMOVE_CANDIDATES: String = "REMOVE_CANDIDATES"//无需定义此常量,因为服务器不处理业务,而是直接转发
        const val LEAVE: String = "LEAVE"//无需定义此常量,因为服务器不处理业务,而是直接转发
    }
}