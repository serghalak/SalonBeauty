package com.salon.common;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER="abcdefghijklmnopqrstuvwxyz";
    private final int LENGHT_USER_NAME=6;
    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    public String generateAddressId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public String getRandomUserName(){
        StringBuilder returnValue = new StringBuilder(5);
        returnValue.append(UPPER.charAt(RANDOM.nextInt(UPPER.length())));
        for (int i = 0; i <LENGHT_USER_NAME-1; i++) {
            returnValue.append(LOWER.charAt(RANDOM.nextInt(LOWER.length())));
        }
        return new String(returnValue);
    }
    //For email activation
    public String getRandomTokenUUID(){
        return UUID.randomUUID().toString();
    }

//    public static boolean hasTokenExpired(String token) {
//        boolean returnValue = false;
//
//        try {
//            Claims claims = Jwts.parser().setSigningKey(SecurityConstants.getTokenSecret()).parseClaimsJws(token)
//                    .getBody();
//
//            Date tokenExpirationDate = claims.getExpiration();
//            Date todayDate = new Date();
//
//            returnValue = tokenExpirationDate.before(todayDate);
//        } catch (ExpiredJwtException ex) {
//            returnValue = true;
//        }
//
//        return returnValue;
//    }
//
//    public String generateEmailVerificationToken(String userId) {
//        String token = Jwts.builder()
//                .setSubject(userId)
//                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
//                .compact();
//        return token;
//    }
//
//    public String generatePasswordResetToken(String userId)
//    {
//        String token = Jwts.builder()
//                .setSubject(userId)
//                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
//                .compact();
//        return token;
//    }

}
