package com.example.webapp03.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    @Autowired
    lateinit var encoder: CustomPasswordEncoder

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            "/images/**",
            "/css/**",
            "/javascript/**",
        )
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/auth/signin", "/auth/signup").permitAll()
            .anyRequest().authenticated()
            .and()

            .formLogin()
            .loginPage("/auth/signin")
            .loginProcessingUrl("/auth/signin")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/post", true)
            .failureHandler(AuthenticationFailureHandler())
            .permitAll()
            .and()

            .logout()
            .logoutSuccessUrl("/auth/signin")
            .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder.passwordEncoder())
    }
}
