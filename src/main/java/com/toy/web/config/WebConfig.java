package com.toy.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정 파일로 정의
public class WebConfig implements WebMvcConfigurer { // web mvc 설정 파일
    @Override // 메서드 오버라이딩
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // endpoint
                .allowedOrigins("http://localhost:5173") // 허용할 origin
                .allowedMethods("*") // 허용할 메서드
                .allowCredentials(true) // 쿠키 인증 요청 여부
                .maxAge(3000); // pre-flight 리퀘스트 캐싱 시간
    }
}
