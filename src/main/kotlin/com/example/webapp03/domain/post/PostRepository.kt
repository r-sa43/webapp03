package com.example.webapp03.domain.post

import org.apache.ibatis.annotations.Mapper

@Mapper
interface PostRepository {

    fun findAll(param: Map<String, Int>): List<PostEntity>

    fun findByUserId(userId: Int): List<PostEntity>

    fun save(param: Map<String, String>)
}
