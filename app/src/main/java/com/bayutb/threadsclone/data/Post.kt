package com.bayutb.threadsclone.data

data class Post(
    val id: Int,
    val user: String,
    val content: String,
    val imageUrl: Int?,
    val embeddedUser: String?,
    val embeddedContent: String?,
    val postLikes: Int,
    val embeddedLikes: Int?,
    val replies: Int,
    val embeddedReplies: Int?
)