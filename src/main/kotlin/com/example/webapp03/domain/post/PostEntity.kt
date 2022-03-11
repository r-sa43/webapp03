package com.example.webapp03.domain.post

import com.example.webapp03.domain.user.UserEntity
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigInteger
import java.util.*

@NoArgsConstructor
@AllArgsConstructor
@Data
class PostEntity {

    val post_id: BigInteger
    val user_id: Int
    val contents: String
    val created: Date
    val users: List<UserEntity>
    val user_one: UserEntity

    init {
        post_id = BigInteger.ZERO
        user_id = 0
        contents = ""
        created = Date()
        users = listOf()
        user_one = UserEntity()
    }
}