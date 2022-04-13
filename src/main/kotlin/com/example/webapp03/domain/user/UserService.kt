package com.example.webapp03.domain.user

import com.example.webapp03.auth.CustomPasswordEncoder
import com.example.webapp03.auth.CustomUserDetails
import com.example.webapp03.web.auth.AuthForm
import com.example.webapp03.web.user.UserForm
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

    @Transactional
    fun updatePassword(userInfo: UserForm, loginUser: CustomUserDetails) {
        val userId = loginUser.getId()
        val password = loginUser.password
        if (encoder.passwordEncoder().matches(userInfo.beforePassword, password)) {
            val user = HashMap<String, String>()
            user["userId"] = userId.toString()
            user["password"] = encoder.passwordEncoder().encode(userInfo.newPassword)

            userRepository.updatePassword(user)
        }
    }
}
