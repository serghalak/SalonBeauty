package com.salon.security;


import com.salon.SpringApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Configuration
//@PropertySource("classpath:security.properties")
public class SecurityConstants {

    //@Value("${expirationTime}")
    //private static int

    //@Value("${expirationTime}")

//    private SecurityProperty securityProperty;
//
//    public SecurityConstants(SecurityProperty securityProperty) {
//        this.securityProperty = securityProperty;
//    }

    //public static long EXPIRATION_TIME;//=securityProperty.experitionTime ;// = 600000;//864000000; // 10 days


    //public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    //@Value("${tokenPrefix}")
    //public  static String TOKEN_PREFIX;// =securityProperty.tokenPrefix;// = "Bearer ";

    //@Value("${headerString}")
    //public static String HEADER_STRING;//=securityProperty.headerString;// = "Authorization";

    //@Value("${signUpUrl}")
    //public static String SIGN_UP_URL;//=securityProperty.signUpUrl;// = "/api/users";

    //@Value("${tokenSecret}")
    //public static String TOKEN_SECRET;//=securityProperty.tokenSecret; //="jf9i4jgu83nfl0";
    //public static final String VERIFICATION_EMAIL_URL = "/users/email-verification";
    //public static final String PASSWORD_RESET_REQUEST_URL = "/users/password-reset-request";
    //public static final String PASSWORD_RESET_URL = "/users/password-reset";
    //public static final String H2_CONSOLE = "/h2-console/**";


//    public static String getTokenSecret(){
//        AppProperties appProperties= (AppProperties) SpringApplicationContext.getBean("AppProperties");
//        return appProperties.getTokenSecret();
//    }



}
