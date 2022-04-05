package com.example.webapp03.auth

import com.example.webapp03.domain.user.UserEntity
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User

class LoginUser(user: UserEntity) : User(
    user.email, user.password,
    AuthorityUtils.createAuthorityList("ROLE_USER")
) {

    var loginUser: UserEntity? = null

    init {
        this.loginUser = user
    }
}
