package com.ssafy.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Moive REST API")
				.description("영화 정보 REST API")
				.version("0.0.1")
				.license(new License().name("ANSMOON").url("https://www.notion.so/Front-End-7c23a37b00334173bdb4bb99ccc14617")));
	}
}