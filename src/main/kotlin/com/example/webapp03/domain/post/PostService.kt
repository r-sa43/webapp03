package com.example.webapp03.domain.post

import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun findAll(): List<PostEntity> {
        return postRepository.findAll()
    }
}
