package com.bayutb.threadsclone.data

import com.bayutb.threadsclone.R
import kotlin.random.Random
import kotlin.random.nextInt

class DataDummy {

    companion object {
        private val _posts = mutableListOf<Post>()
        private val _activityUsers = mutableListOf<User>()
        val posts:List<Post> = _posts
        val activityUser:List<User> = _activityUsers
        val user: User = User(1, "Bayu Tantra Bramandhita", "bayutb123", "Newbie Android and Web Developer\n\uD83C\uDF31 On Eternal Learn", 6969, true)

        fun generate() {
            repeat(10) {
                _posts.add(
                    Post(
                        id = it,
                        user = "bayutb123",
                        content = "Kin bikin clone thread",
                        imageUrl = R.drawable.kitchen_set,
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
                        imageUrl = null,
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
                        imageUrl = null,
                        embeddedUser = "Orang lain ${Random.nextInt(1000, 9999)}",
                        embeddedContent = "FOMO bikin thread",
                        postLikes = 9999,
                        embeddedLikes = 9090,
                        replies = 500,
                        embeddedReplies = 600
                    )
                )
                _activityUsers.add(
                    User(it, "User $it", "user${Random.nextInt(100, 999)}", "Newbie Android and Web Developer\n\uD83C\uDF31 On Eternal Learn", 6969, false)
                )
            }
        }
    }
}