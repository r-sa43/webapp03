package com.example.webapp03.domain.post

import org.apache.ibatis.annotations.Mapper

@Mapper
interface PostRepository {

    fun findAll(param: HashMap<String, Int>): List<PostEntity>

    fun save(param: Map<String, String>)
}
