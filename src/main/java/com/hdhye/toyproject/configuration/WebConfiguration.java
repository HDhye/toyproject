package com.hdhye.toyproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*WebConfiguration 설명
 * {@linkplain: https://velog.io/@jihoon24/스프링부트에서-정적-리소스-설정하기 }
*@author hdhye
*작성일 2023-07-17
**/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /* 1. WebMvcConfigurer <- 해당 인터페이스를 상속받는 클래스를 생성
       2. addResourceHandlers 메서드 오버라이드
       3. 상속 받은 클래스를 스프링부트 실행하는 클래스에 @Im port 시키기 */

    /**
    * WebConfiguration
     * 정적리소스를 관리하는 부분은 addResourceHandlers라는 메서드이다.
     * 해당 메서드의 정의를 보자면 정적 파일들의 경로를 잡아주는 메서드인것을 확인 할 수 있다.
     * (Add handlers to serve static resources such as images, js, and, css files from specific locations
     * under web application root, the classpath, and others.)
    * @author hdhye
     *
    *작성일 2023-07-17
    **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ResourceHandlerRegistry에 addResourceHandlers메서드를 이용해 어느 경로로 들어왔을때 매핑이 되어줄 것인지를 정의한다.
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static"); // 이후 addResourceLocations 메서드를 이용하여 실제 파일이 있는 경로를 지정해 준다.


        // 이미지 불러올 수 있도록 세팅
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
    }

}
