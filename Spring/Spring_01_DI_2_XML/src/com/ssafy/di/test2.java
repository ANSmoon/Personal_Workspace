package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class test2 {
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		
		programmer p = context.getBean("programmer", programmer.class);
		
		p.coding();
	}
}