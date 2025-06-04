package com.v2soft.vpmt.service;

import com.v2soft.vpmt.model.UserEntity;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            "my-super-secret-key-for-jwt-signing!".getBytes(StandardCharsets.UTF_8)
    );

    public String generateToken(UserEntity user) {
        List<String> permissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(p -> p.getName())
                .distinct().toList();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("permissions", permissions)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public List<String> extractPermissions(String token) {
        return extractClaims(token).get("permissions", List.class);
    }
}
