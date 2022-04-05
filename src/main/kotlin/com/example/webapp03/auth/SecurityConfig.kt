package com.example.webapp03.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            "/images/**",
            "/css/**",
            "/javascript/**",
        )
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
//            .antMatchers("/", "/auth/login").permitAll()
            .anyRequest().authenticated()
            .and()

            .formLogin()
            .loginPage("/auth/login")
            .loginProcessingUrl("/auth/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/post", true)
            .failureHandler(AuthenticationFailureHandler())
            .permitAll()
            .and()

            .logout()
            .logoutUrl("/auth/logout")
//            .logoutRequestMatcher(AntPathRequestMatcher("/logout**"))
            .logoutSuccessUrl("/")
            .permitAll()
    }

    @Configuration
    class AuthenticationConfiguration : GlobalAuthenticationConfigurerAdapter() {
        @Autowired
        val userDetailsService: UserDetailsServiceImpl = UserDetailsServiceImpl();

        override fun init(auth: AuthenticationManagerBuilder) {
//            auth.userDetailsService(userDetailsService)
            auth.inMemoryAuthentication()
                .withUser("sashimi@gmail.com")
                .password("{noop}test1")
                .roles("USER")
        }
    }
}
