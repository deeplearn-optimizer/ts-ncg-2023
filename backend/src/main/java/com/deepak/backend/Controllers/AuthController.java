package com.deepak.backend.Controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;

import static com.mysql.cj.MysqlType.JSON;

@RestController
@RequestMapping("/user")
public class AuthController {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    @GetMapping("auth")
    public String generateToken() {
        String token = Jwts.builder()
                .setSubject("user123") // Set subject/user
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Set token expiration
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Sign the token with the secret key
                .compact();

        return token;
    }
}
