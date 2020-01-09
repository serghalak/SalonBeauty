package com.salon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {


    @Value("${security.expirationTime}")
    private Long experitionTime;
    @Value("${security.tokenPrefix}")
    private String tokenPrefix;
    @Value("${security.headerString}")
    private String headerString;
    @Value("${security.signUpUrl}")
    private String signUpUrl;
    @Value("${security.tokenSecret}")
    private String tokenSecret;



    @Bean
    public SecurityProperty securityProperty(){
        SecurityProperty securityProperty=new SecurityProperty();
        securityProperty.setExperitionTime(experitionTime);
        securityProperty.setTokenPrefix(tokenPrefix);
        securityProperty.setHeaderString(headerString);
        securityProperty.setSignUpUrl(signUpUrl);
        securityProperty.setTokenSecret(tokenSecret);
        return securityProperty;
    }



    //    @Bean
//    public static PropertySourcesPlaceholderConfigurer getProperties(){
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=
//                new PropertySourcesPlaceholderConfigurer();
//        return propertySourcesPlaceholderConfigurer;
//    }

//    @Autowired
//    private Environment env;
//
//    public String getTokenSecret(){
//        return env.getProperty("tokenSecret");
//    }
}
