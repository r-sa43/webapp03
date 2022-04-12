package com.example.webapp03.web.good

import com.example.webapp03.auth.CustomUserDetails
import com.example.webapp03.domain.good.GoodService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("good")
class GoodController(
    private val goodService: GoodService
) {

    @PutMapping("")
    fun updateGoodCount(
        @RequestBody goodInfo: GoodInfo,
        result: BindingResult,
        redirectAttributes: RedirectAttributes,
        @AuthenticationPrincipal loginUser: CustomUserDetails
    ): String {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result)
            redirectAttributes.addFlashAttribute("request", goodInfo)

            return "post/list"
        }

        val userId = loginUser.getId()

        if (goodInfo.marked) {
            goodService.countDownGoodCnt(goodInfo.postId, userId)
        } else {
            goodService.countUpGoodCnt(goodInfo.postId, userId)
        }

        return "post/list"
    }
}
