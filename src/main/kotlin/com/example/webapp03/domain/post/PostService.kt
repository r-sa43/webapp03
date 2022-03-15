package com.example.webapp03.domain.post

import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun findAll(limit: Int, offset: Int): List<PostEntity> {
        val param = HashMap<String, Int>()
        param["limit"] = limit
        param["offset"] = offset
        return postRepository.findAll(param)
    }
}
