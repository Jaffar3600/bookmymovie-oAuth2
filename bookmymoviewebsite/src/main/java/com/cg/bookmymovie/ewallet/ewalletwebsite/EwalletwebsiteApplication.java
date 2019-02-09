package com.cg.bookmymovie.ewallet.ewalletwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@EnableWebSecurity
@EnableOAuth2Sso
@SpringBootApplication
public class EwalletwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletwebsiteApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

