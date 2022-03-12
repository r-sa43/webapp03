package com.example.webapp03.web.post

import com.example.webapp03.domain.post.PostService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("post")
class PostController(
    private val postService: PostService,
) {

    // GET /post
    @GetMapping("")
    fun showPostList(model: Model): String {
        model.addAttribute("postList", postService.findAll())
        return "post/list"
    }

//    GET /post/create
    @GetMapping("/create")
    fun showCreateForm(@ModelAttribute postForm: PostForm): String {
        return "post/createPost"
    }

    // POST /post
    @PostMapping("")
    fun createPost(@Validated postForm: PostForm, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return showCreateForm(postForm)
        }
        postService.create(postForm.user_id, postForm.contents)
        return "redirect:/post"
    }


}
