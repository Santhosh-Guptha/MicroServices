package com.RestTemplate.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

//this configuration class is used to implement restTemplate

@Configuration
public class MyConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}



}
