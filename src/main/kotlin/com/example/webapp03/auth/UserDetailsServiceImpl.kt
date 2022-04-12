package com.example.webapp03.auth

import com.example.webapp03.domain.user.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl(
    private val authenticationService: AuthenticationService
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = authenticationService.findUser(email)
        return CustomUserDetails(user)
    }
}

data class CustomUserDetails(var userId: Int, val email: String, val pass: String) : UserDetails {

    constructor(user: UserEntity) : this(user.id, user.email, user.password)

    fun getId(): Int {
        return userId
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList("USER")
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
