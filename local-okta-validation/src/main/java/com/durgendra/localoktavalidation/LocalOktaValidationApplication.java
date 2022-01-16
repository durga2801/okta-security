package com.durgendra.localoktavalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocalOktaValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalOktaValidationApplication.class, args);
	}
	
	@Bean
	public OAuth2ClientProperties oAuth2ClientProperties() {
	    return new OAuth2ClientProperties();
	}

}
