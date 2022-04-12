package com.example.webapp03.domain.post

import com.example.webapp03.domain.user.UserEntity
import java.math.BigInteger
import java.util.Date

class PostEntity {

    val postId: BigInteger = BigInteger.ZERO
    val userId: Int = 0
    val contents: String = ""
    val created: Date = Date()
    val goodCounts: Int = 0
    val user: UserEntity = UserEntity()
}
