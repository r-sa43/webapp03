package com.example.webapp03.web.auth

import com.example.webapp03.domain.user.UserEntity
import com.example.webapp03.domain.user.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("auth")
class AuthController(
    private val userService: UserService,
) {

    @GetMapping("/login")
    fun showLoginForm(
        @ModelAttribute authForm: AuthForm,
    ): String {
        println("GET auth/login")
        val user: UserEntity = userService.findByEmail("sashimi@gmail.com")
        println(user)
        return "auth/login"
    }

//    @PostMapping("/login")
//    fun login(): String {
//        println("POST auth/login")
//        return "redirect:/post"
//    }
}
