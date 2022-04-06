package com.example.webapp03.web.auth

import com.example.webapp03.auth.CustomPasswordEncoder
import com.example.webapp03.domain.user.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("auth")
class AuthController(
    private val userService: UserService,
    private val encoder: CustomPasswordEncoder,
) {

    @GetMapping("/signin")
    fun showLoginForm(): String {
        return "auth/signin"
    }

    @GetMapping("/signup")
    fun showSignInForm(
        @ModelAttribute authForm: AuthForm,
    ): String {
        return "auth/signup"
    }

    @PostMapping("/signup")
    fun signup(authForm: AuthForm): String {
        val user = HashMap<String, String>()
        user["name"] = authForm.name
        user["email"] = authForm.email
        user["password"] = encoder.passwordEncoder().encode(authForm.password)
        userService.save(user)
        return "redirect:/post"
    }
}
