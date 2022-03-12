package com.example.webapp03.web.post

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class PostForm {
    val user_id: Int = 1

    @NotBlank
    @Size(max=256)
    val contents: String = ""
}
