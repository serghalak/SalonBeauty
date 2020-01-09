package com.salon;

import com.salon.security.AppProperties;
import com.salon.security.SecurityProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SalonBeautyApplication
		/*extends SpringBootServletInitializer*/{


//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		//return super.configure(builder);
//		return application.sources(SalonBeautyApplication.class);
//	}

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
