package com.example.webapp03.errorHandler

import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Component
class GlobalControlAdvice {

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(
        ex: Exception,
        model: Model
    ): String{
        model.addAttribute("error", "Internal Server Error")
        model.addAttribute("message", "Happened Exception")
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR)

        return "error"
    }

    @ExceptionHandler(DuplicateKeyException::class)
    fun duplicateKeyExceptionHandler(
        ex: DuplicateKeyException,
        model: Model
    ): String {
        model.addAttribute("error", "Internal Server Error")
        model.addAttribute("message", "DuplicateKeyException")

        return "error"
    }
}
