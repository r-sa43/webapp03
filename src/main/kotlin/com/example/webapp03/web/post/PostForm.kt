package com.example.webapp03.web.post

import lombok.Data
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Data
class PostForm {
    var user_id: Int = 1

    @NotBlank
    @Size(max=256)
    var contents: String = ""
}