package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public desktop desktop() {
		return new desktop();
	}
	
	@Bean
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean
	public programmer programmer() {
		// 생성자 주입 방식
		programmer p = new programmer(desktop());
		return p;
		// 설정자 주입 방식도 가능하다.
	}
}
