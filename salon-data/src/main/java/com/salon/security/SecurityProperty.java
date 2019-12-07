package com.salon.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Configuration
//@PropertySource("classpath:security.properties")
//@ConfigurationProperties(prefix = "security")
//@PropertySources({
//        @PropertySource("classpath: security.properties"),
//        @PropertySource("classpath:datasource.properties")
//})
public class SecurityProperty {


    private Long experitionTime;
    private String tokenPrefix;
    private String headerString;
    private String signUpUrl;
    private String tokenSecret;

    public Long getExperitionTime() {
        return experitionTime;
    }

    public void setExperitionTime(Long experitionTime) {
        this.experitionTime = experitionTime;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public String getHeaderString() {
        return headerString;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }



//
//    @Bean
//    public void getSecurityConstants(){
//        SecurityConstants.EXPIRATION_TIME=experitionTime;
//        SecurityConstants.TOKEN_PREFIX=tokenPrefix;
//        SecurityConstants.HEADER_STRING=headerString;
//        SecurityConstants.SIGN_UP_URL=signUpUrl;
//        SecurityConstants.TOKEN_SECRET=tokenSecret;
//    }
}
