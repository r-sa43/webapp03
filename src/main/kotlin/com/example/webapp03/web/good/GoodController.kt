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
        println(goodInfo.post_id)
        println(goodInfo.is_marked)
        if (goodInfo.is_marked) {
            goodService.countDownGoodCnt(goodInfo.post_id)
        } else {
            goodService.countUpGoodCnt(goodInfo.post_id)
        }

        return "post/list"
    }
}
