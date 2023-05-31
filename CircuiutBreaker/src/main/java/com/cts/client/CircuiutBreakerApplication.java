package com.cts.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker
@SpringBootApplication
public class CircuiutBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuiutBreakerApplication.class, args);
	}
	@Bean
	public RestTemplate makenewtemplate() {
		return new RestTemplate();
	}

}
