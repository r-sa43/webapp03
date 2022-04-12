package com.example.webapp03.domain.good

import org.apache.ibatis.annotations.Mapper

@Mapper
interface GoodRepository {

    fun findByUserId(userId: Int): List<Int>

    fun save(param: Map<String, Int>)

    fun delete(param: Map<String, Int>)
}
