package com.example.webapp03.web.good

import com.example.webapp03.domain.good.GoodService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("good")
class GoodController(
    private val goodService: GoodService
) {

    @PutMapping
    fun countUp(
        @RequestParam("post_id") post_id: Int,
    ): String {
        goodService.countUpGoodCnt(post_id)

        return "post/list"
    }

//    @DeleteMapping
//    fun countDown(){
//        goodService.countDownGoodCnt()
//    }
}
