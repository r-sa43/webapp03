package com.example.webapp03.domain.post

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    fun findAll(): List<PostEntity> {
        return postRepository.findAll()
    }

    @Transactional
    fun create(user_id: Int, contents: String) {
        val isValidLen: Boolean = validateStrLength(contents)
        val param = HashMap<String, String>()
        param["userId"] = user_id.toString()
        param["contents"] = contents
        if (isValidLen) {
            postRepository.save(param)
        }
    }

    fun validateStrLength(contents: String): Boolean {
        var ret = 0
        val charArr: CharArray = contents.toCharArray()
        for (charContent in charArr) {
            ret += if (charContent.toString().toByteArray().size <= 1) 1 else 2
        }

        val maxLen = 280
        return ret <= maxLen
    }
}
