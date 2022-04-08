package com.example.webapp03.web.auth

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

class AuthForm {

    @Email
    @NotEmpty
    var email = ""

    @NotEmpty
    var password = ""

    @NotEmpty
    var name = ""
}
