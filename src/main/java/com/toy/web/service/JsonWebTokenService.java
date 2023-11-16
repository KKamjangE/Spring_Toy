package com.toy.web.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JsonWebTokenService {

    @Value("${jwt.expritation}")
    private long expiration; // jwt 유효기간

    @Value("${jwt.secretKey}")
    private String secretKey;

    public SecretKey generateSecretKey() {
        // 문자열을 UTF-8 문자 인코딩으로 바이트 배열로 변환한다
        // 해당 바이트 배열을 사용하여 HMAC-SHA 알고리즘에 기반한 SecretKey를 생성한다
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String userId) {
        Date now = new Date(); // 현재 시간
        Date expirationDate = new Date(now.getTime() + (1000 * 60 * expiration)); // 현재 시간 + 유효기간

        SecretKey key = generateSecretKey();

        return Jwts.builder()
                .signWith(key)
                .subject(userId)
                .issuedAt(now)
                .expiration(expirationDate)
                .compact();
    }

    public String checkToken(String jws) {
        SecretKey key = generateSecretKey();

        String subject = Jwts.parser().verifyWith(key).build().parseSignedClaims(jws).getPayload().getSubject();
        if(subject.isEmpty()) {
            return null;
        } else {
            return subject;
        }
    }
}
