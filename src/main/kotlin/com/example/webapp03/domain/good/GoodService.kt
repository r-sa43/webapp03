package com.example.webapp03.domain.good

import com.example.webapp03.config.Constants
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoodService(
    private val goodRepository: GoodRepository,
) {

    fun findListByUserId(userId: Int): List<Int> {
        return goodRepository.findByUserId(userId)
    }

    @Transactional
    fun countUpGoodCnt(postId: Int, userId: Int) {
        val param = HashMap<String, Int>()
        param["userId"] = userId
        param["postId"] = postId
        goodRepository.save(param)
    }

    @Transactional
    fun countDownGoodCnt(postId: Int, userId: Int) {
        val param = HashMap<String, Int>()
        param["userId"] = userId
        param["postId"] = postId
        goodRepository.delete(param)
    }
}
