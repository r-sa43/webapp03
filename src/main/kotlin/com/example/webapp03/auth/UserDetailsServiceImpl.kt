package com.example.webapp03.auth

import com.example.webapp03.domain.user.UserEntity
import com.example.webapp03.domain.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    lateinit var userService: UserService

    override fun loadUserByUsername(email: String): UserDetails {
        val user: UserEntity?

        try {
            user = userService.findByEmail(email)
            println("UserDetailsServiceImpl is")
            println(user.email)
            println(user.password)
        } catch (e: Exception) {
            throw UsernameNotFoundException("It can not be acquired User")
        }

        val grantList: MutableList<GrantedAuthority> = ArrayList()
        val authority: GrantedAuthority = SimpleGrantedAuthority("USER")
        grantList.add(authority)

        val encoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
//        return LoginUser(user)
        return User(user.email, encoder.encode(user.password), grantList)
    }
}
