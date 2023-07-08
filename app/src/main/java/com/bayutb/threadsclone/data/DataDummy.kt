package com.bayutb.threadsclone.data

import kotlin.random.Random

class DataDummy {

    companion object {
        private val _posts = mutableListOf<Post>()
        val posts:List<Post> = _posts

        fun generate() {
            repeat(30) {
                _posts.add(
                    Post(
                        id = it,
                        user = "bayutb123",
                        content = "Kin bikin clone thread",
                        embeddedUser = null,
                        embeddedContent = null,
                        postLikes = 9999,
                        embeddedLikes = null,
                        replies = 500,
                        embeddedReplies = null
                    )
                )
                _posts.add(
                    Post(
                        id = it,
                        user = "bayutb123",
                        content = "Threads bisa disebut kloning Twitter berbasis teks dari Instagram, jejaring sosial yang dibeli Facebook lebih dari satu dekade lalu dan menjadi aplikasi paling populer di dunia untuk berbagi foto dan video.",
                        embeddedUser = null,
                        embeddedContent = null,
                        postLikes = 9999,
                        embeddedLikes = null,
                        replies = 500,
                        embeddedReplies = null
                    )
                )
                _posts.add(
                    Post(
                        id = it,
                        user = "bayutb123",
                        content = "FOMO bikin thread? \nFomo bikin clone appnya lah",
                        embeddedUser = "Orang lain ${Random.nextInt(1000, 9999)}",
                        embeddedContent = "FOMO bikin thread",
                        postLikes = 9999,
                        embeddedLikes = 9090,
                        replies = 500,
                        embeddedReplies = 600
                    )
                )
            }
        }
    }
}