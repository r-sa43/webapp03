package com.example.webapp03.domain.user

import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository
    ){

    fun findByEmail(email: String): UserEntity {
        return userRepository.findByEmail(email)
    }

    fun save(user: Map<String, String>) {
        userRepository.save(user)
    }
}
