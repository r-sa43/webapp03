package com.example.webapp03.auth

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthenticationFailureHandler : AuthenticationFailureHandler {

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        authenticationException: AuthenticationException
    ) {

        var errorId = "ERR-0000"
        if (authenticationException is BadCredentialsException) {
            errorId = "ERR-0001"
        }

        httpServletResponse.sendRedirect(httpServletRequest.contextPath + "?error=" + errorId)
    }
}
