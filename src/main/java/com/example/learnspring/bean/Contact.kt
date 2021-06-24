package com.example.learnspring.bean

data class Contact(val account: String){

    override fun hashCode(): Int {
        return account.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (account != other.account) return false

        return true
    }

}
