package com.demo.config.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String APP_SECRET = "JDSAdGdFjJjJhGfgVvhuiUhHhJJKkHJHJhkjkHJKJKjkHJ";

    public static String getToken(Map<Object, Object> map) {
        JwtBuilder builder = Jwts.builder();
//这里可以实现外部动态传参
        map.forEach((k, v) -> {
                    builder.claim(String.valueOf(k), v);
                }
        );
        String token = builder
//token开始起作用的时间
                .setIssuedAt(new Date())
//token失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(Keys.hmacShaKeyFor(APP_SECRET.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
        System.out.println("token:" + token);
        return token;
    }

    public static void verify(String token) {
        Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(APP_SECRET.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);
    }

    public static Jws<Claims> tokenInfo(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(APP_SECRET.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);
        return claimsJws;
    }

}
