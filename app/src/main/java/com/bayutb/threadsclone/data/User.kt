package com.bayutb.threadsclone.data

data class User(
    val id : Int,
    val name: String,
    val userId : String,
    val description: String?,
    val followers: Int,
    val isVerified : Boolean
)
