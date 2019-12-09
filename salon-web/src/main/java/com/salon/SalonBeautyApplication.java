package com.salon;

import com.salon.security.AppProperties;
import com.salon.security.SecurityProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SalonBeautyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonBeautyApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext(){
		return new SpringApplicationContext();
	}

//	@Bean
//	public AppProperties getAppProperties(){
//		return new AppProperties();
//	}


}
