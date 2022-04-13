package com.example.webapp03.web.user

import com.example.webapp03.auth.CustomUserDetails
import com.example.webapp03.domain.user.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("user")
class UserController(
    private val userService: UserService
) {

    @GetMapping("")
    fun changePassword(@ModelAttribute userForm: UserForm): String {
        return "/user/passwordChange"
    }

    @PostMapping("")
    fun changePassword(
        @Validated userForm: UserForm,
        bindingResult: BindingResult,
        @AuthenticationPrincipal loginUser: CustomUserDetails
    ): String {
        userService.updatePassword(userForm, loginUser)
        return "redirect:/auth/signin"
    }
}
