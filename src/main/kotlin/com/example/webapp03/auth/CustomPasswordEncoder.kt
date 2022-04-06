package com.example.webapp03.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomPasswordEncoder {

    @Autowired
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
