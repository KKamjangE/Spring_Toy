package com.toy.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // 스프링 시큐리티 활성화
@Configuration // 설정 정보 환경 세팅을 도와줌
public class SecurityConfig {

    // SecurityFilterChain은 보안 필터 체인을 구성하는데 사용
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // csrf 사이트 요청 위조 비활성화
                .authorizeHttpRequests((authorizeRequest) -> { // 웹 요청에 대한 권한 부여 및 인가 규칙 정의
                    authorizeRequest.requestMatchers("/auth/**", "/sign/**").permitAll(); // 해당 URL 시작하는 요청은 모두 접근 허용
                    authorizeRequest.requestMatchers("/static/**").permitAll(); // 정적 파일에 대한 모든 요청 허용
                })
                .formLogin((formLogin) -> { // 권한이 필요한 요청을 해당 URL로 넘긴다
                    formLogin.loginPage("/auth/login"); // 로그인 페이지로 이동
                });

        return http.build(); // 체인을 만들고 반환한다
    }

}
