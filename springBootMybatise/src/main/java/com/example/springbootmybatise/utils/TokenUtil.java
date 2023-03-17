package com.example.springbootmybatise.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    //过期时间设置
    private static final long expireTime = 24*60*60*10000;

    //token密钥设置
    private static final String tokenKey = "tokenTestFirstTime";

    public static String getToken(String userName,String password){
        String token = "";

        try{
            //过期时间
            Date date = new Date(System.currentTimeMillis()+expireTime);

            //密钥加密算法
            Algorithm algorithm = Algorithm.HMAC256(tokenKey);

            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");

            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userName",userName)
                    .withClaim("password",password).withExpiresAt(date)
                    .sign(algorithm);


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return token;

    }

    public static boolean verify(String token){
        /**
         * 验证token，通过返回true
         * @params [token]需要校验的串
         */
        try{
            Algorithm algorithm = Algorithm.HMAC256(tokenKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}