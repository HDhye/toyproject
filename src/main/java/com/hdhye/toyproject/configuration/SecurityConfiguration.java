package com.hdhye.toyproject.configuration;

import com.hdhye.toyproject.model.service.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // 빈 등록
public class SecurityConfiguration {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    /* 시큐리티 설정 무시 정적 리소스 등록 */
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring().antMatchers("/css/**", "images/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService).build();



    }




}
