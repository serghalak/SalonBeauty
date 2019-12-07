package com.salon.security;


import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private SecurityProperty securityProperty;


    public AuthorizationFilter(AuthenticationManager authenticationManager
            ,SecurityProperty securityProperty) {
        super(authenticationManager);
        this.securityProperty = securityProperty;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        //super.doFilterInternal(request, response, chain);
        String header=request.getHeader(securityProperty.getHeaderString());
        if(header == null || !header.startsWith(securityProperty.getTokenPrefix())){
            chain.doFilter(request,response);
            return ;
        }
        UsernamePasswordAuthenticationToken authentication=getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader(securityProperty.getHeaderString());

        if(token != null){
            token=token.replace(securityProperty.getTokenPrefix(),"");
            String user= Jwts.parser()
                    .setSigningKey(securityProperty.getTokenSecret())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if(user != null){
                return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
            }
        }
        return null;
    }
}
