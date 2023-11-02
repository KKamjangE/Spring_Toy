package com.toy.web.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JsonWebTokenService {

    @Value("${jwt.expritation}")
    private long expiration; // jwt 유효기간

    public String generateToken(String userId) {
        Date now = new Date(); // 현재 시간
        Date expirationDate = new Date(now.getTime() + expiration); // 현재 시간 + 유효기간

        SecretKey key = Jwts.SIG.HS256.key().build();
        return Jwts.builder()
                .signWith(key)
                .subject(userId)
                .issuedAt(now)
                .expiration(expirationDate)
                .compact();
    }
}
