package com.example.webapp03.auth

import com.example.webapp03.domain.user.UserEntity
import com.example.webapp03.domain.user.UserService
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userService: UserService
) {

    fun findUser(email: String): UserEntity {
        return userService.findByEmail(email)
    }
}
