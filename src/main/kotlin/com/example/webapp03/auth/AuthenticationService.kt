package com.example.webapp03.auth

import com.example.webapp03.domain.user.UserEntity
import com.example.webapp03.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {

    fun findUser(email: String): UserEntity {
        return userRepository.findByEmail(email)
    }
}
