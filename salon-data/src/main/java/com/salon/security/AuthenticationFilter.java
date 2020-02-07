package com.salon.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.salon.SpringApplicationContext;
import com.salon.dto.UserClientDto;
import com.salon.dto.UserDto;
import com.salon.security.SecurityConstants;
import com.salon.services.UserService;
import com.salon.ui.model.request.UserRegisterData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;



public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private  SecurityProperty securityProperty;


    public AuthenticationFilter(AuthenticationManager authenticationManager , SecurityProperty securityProperty) {
        this.authenticationManager = authenticationManager;
        this.securityProperty=securityProperty;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        //return super.attemptAuthentication(request, response);

        try{
            //ObjectMapper convert JSON from stream to java object
            UserRegisterData creds=new ObjectMapper().readValue(request.getInputStream(), UserRegisterData.class);
            //System.out.println(">>>>>>>>>>>>>>>>>>> " + securityProperty.getHeaderString());
            //System.out.println("UsernamePasswordAuthenticationFilter->attemptAuthentication: "
            //        + creds.getUserName()+": " + creds.getPassword());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUserName(),
                            creds.getPassword(),
                            new ArrayList<GrantedAuthority>()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        //super.successfulAuthentication(request, response, chain, authResult);


        String userName = ((org.springframework.security.core.userdetails.User)authResult.getPrincipal()).getUsername();
        String token= Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + securityProperty.getExperitionTime()))
                .signWith(SignatureAlgorithm.HS512, securityProperty.getTokenSecret())
                .compact();
        UserService userService= (UserService) SpringApplicationContext.getBean("userServiceImpl");
        //UserClientDto userDto=userService.getUser(userName);
        UserDto userDto=userService.getUser(userName);

        String userId = userDto.getUserId();

        response.addHeader(securityProperty.getHeaderString(), securityProperty.getTokenPrefix()+token);

        response.addHeader("UserID",userId);
    }


}
