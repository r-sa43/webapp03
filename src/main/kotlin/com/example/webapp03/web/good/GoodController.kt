package com.example.webapp03.web.good

import com.example.webapp03.domain.good.GoodService
import com.example.webapp03.domain.user.UserService
import org.springframework.dao.DuplicateKeyException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("good")
class GoodController(
    private val goodService: GoodService,
    private val userService: UserService,
) {

    @PutMapping("")
    fun updateGoodCount(
        @RequestBody goodInfo: GoodInfo,
        result: BindingResult,
        redirectAttributes: RedirectAttributes,
        loginUser: Authentication,
    ): String {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result)
            redirectAttributes.addFlashAttribute("request", goodInfo)

            return "post/list"
        }

        val userId: Int = userService.findByEmail(loginUser.name).id

        if (goodInfo.marked) {
            goodService.countDownGoodCnt(goodInfo.postId, userId)
        } else {
            goodService.countUpGoodCnt(goodInfo.postId, userId)
        }

        return "post/list"
    }
}
