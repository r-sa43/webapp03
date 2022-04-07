package com.example.webapp03.web.post

import javax.validation.constraints.NotBlank

class PostForm {
    @NotBlank
    var contents: String = ""
}
