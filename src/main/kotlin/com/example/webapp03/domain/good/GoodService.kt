package com.example.webapp03.domain.good

import com.example.webapp03.config.CONST
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoodService(
    private val goodRepository: GoodRepository,
    private val const: CONST
) {

    @Transactional
    fun countUpGoodCnt(post_id: Int) {
        val param = HashMap<String, String>()
        param["userId"] = const.userId.toString()
        param["postId"] = post_id.toString()
        goodRepository.save(param)
    }

    @Transactional
    fun countDownGoodCnt(post_id: Int) {
        val param = HashMap<String, String>()
        param["userId"] = const.userId.toString()
        param["postId"] = post_id.toString()
        goodRepository.delete(param)
    }
}
