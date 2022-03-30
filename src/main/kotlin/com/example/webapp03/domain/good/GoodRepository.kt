package com.example.webapp03.domain.good

import org.apache.ibatis.annotations.Mapper

@Mapper
interface GoodRepository {

    fun save(param: Map<String, String>)

    fun delete(param: Map<String, String>)
}
