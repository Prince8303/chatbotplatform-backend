package com.yellowai.chatbotplatform.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "chatbotplatform-secret-key-very-secure-12345";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    //  Generate signing key from raw bytes
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    //  Generate JWT token
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //  Extract username/email from token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //  Validate token
    public boolean isTokenValid(String token, UserDetails userDetails) {

        String username = extractUsername(token);
        return username.equals(userDetails.getUsername());
    }
}
