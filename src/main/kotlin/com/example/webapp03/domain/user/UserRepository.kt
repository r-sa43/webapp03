package com.example.webapp03.domain.user

import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserRepository {

    fun findByEmail(email: String): UserEntity

    fun save(user: Map<String, String>)
}
