package com.example.webapp03.web.good

import com.example.webapp03.domain.good.GoodService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("good")
class GoodController(
    private val goodService: GoodService
) {

    @PutMapping("")
    fun updateGoodCount(
        @RequestBody goodInfo: GoodInfo
    ): String {
        if (goodInfo.marked) {
            goodService.countDownGoodCnt(goodInfo.postId)
        } else {
            goodService.countUpGoodCnt(goodInfo.postId)
        }

        return "post/list"
    }
}
