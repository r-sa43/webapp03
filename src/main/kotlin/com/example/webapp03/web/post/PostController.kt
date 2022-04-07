package com.example.webapp03.web.post

import com.example.webapp03.domain.post.PostEntity
import com.example.webapp03.domain.post.PostService
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
) {

    @GetMapping("")
    fun showPostList(
        @RequestParam("limit", defaultValue = "100", required = false) limit: Int,
        @RequestParam("offset", defaultValue = "0", required = false) offset: Int,
        model: Model
    ): String {
        model.addAttribute("postList", postService.findAll(limit, offset))
        return "post/list"
    }

    @GetMapping("/create")
    fun showCreateForm(@ModelAttribute postForm: PostForm): String {
        return "post/createPost"
    }

    @PostMapping("")
    fun createPost(@Validated postForm: PostForm, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return showCreateForm(postForm)
        }
        postService.create(postForm.user_id, postForm.contents)
        return "redirect:/post"
    }
}
