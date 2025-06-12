package com.stellants.vdpmt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService {
    @Value("${app.jwt.secret}")
    private String secret;// 256-bit key
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret); // base64 string
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}

