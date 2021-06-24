package com.example.learnspring.manager

import com.example.learnspring.bean.Contact

object ContactManager {
    private val contactMap: MutableMap<String, Contact> = mutableMapOf()

    fun addContact(account: String, contact: Contact) {
        contactMap[account] = contact
    }

    fun removeContact(account: String) {
        contactMap.remove(account)
    }

    fun getContact(account: String): Contact? {
        return contactMap[account]
    }


}