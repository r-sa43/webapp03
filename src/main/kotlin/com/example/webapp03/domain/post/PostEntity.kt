package com.example.webapp03.domain.post

import com.example.webapp03.domain.user.UserEntity
import java.math.BigInteger
import java.util.Date

class PostEntity {

    val post_id: BigInteger = BigInteger.ZERO
    val user_id: Int = 0
    val contents: String = ""
    val created: Date = Date()
    val users: List<UserEntity> = listOf()
    val goodCounts: Int = 0
}
