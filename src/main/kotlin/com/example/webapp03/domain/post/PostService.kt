package com.example.webapp03.domain.post

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class PostService (
    private val postRepository: PostRepository
){

    fun findAll(): List<PostEntity> {
        return postRepository.findAll()
    }
}