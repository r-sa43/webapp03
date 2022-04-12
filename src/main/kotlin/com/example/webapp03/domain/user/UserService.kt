package com.example.webapp03.domain.user

import com.example.webapp03.auth.CustomPasswordEncoder
import com.example.webapp03.web.auth.AuthForm
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val encoder: CustomPasswordEncoder
) {

    fun findByEmail(email: String): UserEntity {
        return userRepository.findByEmail(email)
    }

    @Transactional
    fun save(authForm: AuthForm) {
        val user = HashMap<String, String>()
        user["name"] = authForm.name
        user["email"] = authForm.email
        user["password"] = encoder.passwordEncoder().encode(authForm.password)

        val existUser: UserEntity = findByEmail(authForm.email)
        if (existUser == null) {
            userRepository.save(user)
        }
    }
}
