package com.example.webapp03

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("/")
    fun showLoginForm(): String {
        return "redirect:/post"
    }
}
