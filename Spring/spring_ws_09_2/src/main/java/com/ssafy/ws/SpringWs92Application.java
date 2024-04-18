package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.SessionInterceptor;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.ws.model.dao")
public class SpringWs92Application implements WebMvcConfigurer {
	
	@Autowired
	SessionInterceptor sessionInterceptor;
	
	// 인터셉터 설정 추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/regist");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWs92Application.class, args);
	}
}