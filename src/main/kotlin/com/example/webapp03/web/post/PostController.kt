package com.example.webapp03.web.post

import com.example.webapp03.auth.CustomUserDetails
import com.example.webapp03.domain.good.GoodService
import com.example.webapp03.domain.post.PostService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("post")
class PostController(
    private val postService: PostService,
    private val goodService: GoodService
) {

    @GetMapping("")
    fun showPostList(
        @RequestParam("limit", defaultValue = "100", required = false) limit: Int,
        @RequestParam("offset", defaultValue = "0", required = false) offset: Int,
        model: Model,
        @AuthenticationPrincipal loginUser: CustomUserDetails
    ): String {
        model.addAttribute("postList", postService.findAll(limit, offset))

        val userId = loginUser.getId()
        model.addAttribute("goodList", goodService.findListByUserId(userId))
        return "post/list"
    }

    @GetMapping("/create")
    fun showCreateForm(@ModelAttribute postForm: PostForm): String {
        return "post/createPost"
    }

    @GetMapping("/me")
    fun showMyPostList(
        model: Model,
        @AuthenticationPrincipal loginUser: CustomUserDetails
    ): String {
        val userId = loginUser.getId()
        model.addAttribute("postList", postService.findByUserId(userId))
        return "post/postMe"
    }

    @PostMapping("")
    fun createPost(@Validated postForm: PostForm, bindingResult: BindingResult, model: Model, @AuthenticationPrincipal loginUser: CustomUserDetails): String {
        if (bindingResult.hasErrors()) {
            return showCreateForm(postForm)
        }
        val userId = loginUser.getId()
        postService.create(userId, postForm.contents)
        return "redirect:/post"
    }

    @PostMapping("/me/{postId}")
    fun deletePost(@PathVariable("postId") postId: Int, @AuthenticationPrincipal loginUser: CustomUserDetails): String {
        val userId = loginUser.getId()
        postService.deletePost(userId, postId)

        return "redirect:/post/me"
    }
}
