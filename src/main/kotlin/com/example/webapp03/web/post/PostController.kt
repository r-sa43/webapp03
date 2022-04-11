package com.example.webapp03.web.post

import com.example.webapp03.domain.good.GoodService
import com.example.webapp03.domain.post.PostService
import com.example.webapp03.domain.user.UserService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("post")
class PostController(
    private val postService: PostService,
    private val userService: UserService,
    private val goodService: GoodService
) {

    @GetMapping("")
    fun showPostList(
        @RequestParam("limit", defaultValue = "100", required = false) limit: Int,
        @RequestParam("offset", defaultValue = "0", required = false) offset: Int,
        model: Model,
        loginUser: Authentication
    ): String {
        model.addAttribute("postList", postService.findAll(limit, offset))

        val userId: Int = userService.findByEmail(loginUser.name).id
        model.addAttribute("goodList", goodService.findListByUserId(userId))
        return "post/list"
    }

    @GetMapping("/create")
    fun showCreateForm(@ModelAttribute postForm: PostForm): String {
        return "post/createPost"
    }

    @PostMapping("")
    fun createPost(@Validated postForm: PostForm, bindingResult: BindingResult, model: Model, loginUser: Authentication): String {
        if (bindingResult.hasErrors()) {
            return showCreateForm(postForm)
        }
        val userId: Int = userService.findByEmail(loginUser.name).id
        postService.create(userId, postForm.contents)
        return "redirect:/post"
    }
}
