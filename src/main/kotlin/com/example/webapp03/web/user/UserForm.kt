package com.example.webapp03.web.user

import org.jetbrains.annotations.NotNull

class UserForm {

    @NotNull
    var userId: Int = 0

    @NotNull
    var beforePassword: String = "" // Password before change

    @NotNull
    var newPassword: String = "" // new password

    var password: String = "" // registered password
}
