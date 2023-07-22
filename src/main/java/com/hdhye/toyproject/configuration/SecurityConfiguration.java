package com.hdhye.toyproject.configuration;

import com.hdhye.toyproject.model.service.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration      // 빈 등록
public class SecurityConfiguration {

    private PrincipalOauth2UserService principalOauth2UserService;

    @Autowired
    public SecurityConfiguration(PrincipalOauth2UserService principalOauth2UserService) {
        this.principalOauth2UserService = principalOauth2UserService;
    }

    /* 비밀번호 암호화 사용객체 등록 */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /* 시큐리티 설정 무시 정적 리소스 등록 */
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring().antMatchers("/css/**", "images/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        return http.csrf().disable()    // csrt 토큰위주 공격을 막기위한 작업(default == on)
                .authorizeRequests()// 요청에 대한 권한 체크를 어떻게 할 것인지 지정
                .antMatchers("/").authenticated()// /로 들어온 것에 대해서 하나의 권한을 등록(인증된 사용자만 접근 가능)
//                .antMatchers(HttpMethod.GET, "/notice/**").hasRole("MEMBER") // 멤버는 조회만 가능
//                .antMatchers(HttpMethod.POST, "/notice/**").hasRole("ADMIN")
//                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .anyRequest().permitAll()
            .and()
                .formLogin()// 로그인 form을 따로 이용해 로그인 처리할 것이다.
                .loginPage("/login") // 로그인페이지 submit요청 경로. (POST일 경우에 설정을 따로 안해주면 여기로 찾아온다)
                .loginProcessingUrl("/logipROC")
                .successForwardUrl("/")  // 성공시 페이지
                .defaultSuccessUrl("/")
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃시 요청 경로
                .deleteCookies("JSESSIONID") // 쿠키제거
                .invalidateHttpSession(true)                        // 세션도 무효화
            .and()
                .exceptionHandling() // 인가/인증 exception핸들링 설정
                .accessDeniedPage("/denied")    // 권한없는 기능 요청시 나타날 페이지
            .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService)
                .build();



    }




}
