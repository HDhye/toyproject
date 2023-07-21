package com.hdhye.toyproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // 빈 등록
public class SecurityConfiguration {

    /* 시큐리티 설정 무시 정적 리소스 등록 */
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring().antMatchers("/css/**", "images/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {

        http.csrf().disable();
        return http.authorizeRequests().build();


    }




}
