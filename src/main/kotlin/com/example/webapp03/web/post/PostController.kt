package com.example.webapp03.web.post

import com.example.webapp03.domain.post.PostService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("post")
class PostController(
    private val postService: PostService,
) {

    // GET /
    @GetMapping("")
    fun showPostList(
        @RequestParam("limit", defaultValue = "100", required = false) limit: Int,
        @RequestParam("offset", defaultValue = "0", required = false) offset: Int,
        model: Model
    ): String {
        model.addAttribute("postList", postService.findAll(limit, offset))
        return "post/list"
    }
}
