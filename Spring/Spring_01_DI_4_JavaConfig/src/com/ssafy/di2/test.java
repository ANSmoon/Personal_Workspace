package com.ssafy.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		programmer p = context.getBean("programmer",programmer.class);
		p.coding();
	}
}