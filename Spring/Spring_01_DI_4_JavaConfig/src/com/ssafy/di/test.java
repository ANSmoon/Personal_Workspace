package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		programmer p = context.getBean("programmer",programmer.class);
		p.coding();
		
		desktop d1 = context.getBean("desktop", desktop.class);
		desktop d2 = context.getBean("desktop", desktop.class);
		
		System.out.println(d1 == d2);
	}
}