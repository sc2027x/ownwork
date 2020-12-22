package com.platform.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JwtUtil {
    /**
     * 加密的secret
     */
    private static final String secret = "OvenSecret";

    /**
     * 生成token
     */
    public static String generateToken(Map<String, Object> map) {
        if (Objects.isNull(map)) {
            map = new HashMap<>();
        }
        long expire = 15 * 60;
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000); // 过期时间设为15分钟
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")   // 设置头部信息
                .setClaims(map)                 // 装入自定义的用户信息
                .setExpiration(expireDate)      // token过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 校验token并解析token
     *
     * @return Claims：它继承了Map,而且里面存放了生成token时放入的用户信息
     */
    public static Claims verifyAndGetClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取token
     * @return token
     */
    public static String getHeaderKey() {
        return "token";
    }
}
