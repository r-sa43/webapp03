package com.example.webapp03.web.auth

import com.example.webapp03.domain.user.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("auth")
class AuthController(
    private val userService: UserService
) {

    @GetMapping("/signin")
    fun showLoginForm(): String {
        return "auth/signin"
    }

    @GetMapping("/signup")
    fun showSignInForm(@ModelAttribute authForm: AuthForm): String {
        return "auth/signup"
    }

    @PostMapping("/signup")
    fun signup(@Validated authForm: AuthForm, bindingResult: BindingResult): String {
        userService.save(authForm)
        return "redirect:/post"
    }
}
