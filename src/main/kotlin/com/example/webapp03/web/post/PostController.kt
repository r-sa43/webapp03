package com.example.webapp03.web.post

import com.example.webapp03.domain.post.PostService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("post")
class PostController(
    private val postService: PostService,
) {

    // GET /
    @GetMapping("")
    fun showPostList(model: Model): String {
        model.addAttribute("postList", postService.findAll())
        return "post/list"
    }
}
