package com.example.webapp03.web.post

import javax.validation.constraints.NotBlank

class PostForm {
    val user_id: Int = 1

    val email: String = ""

    @NotBlank
    var contents: String = ""
}
