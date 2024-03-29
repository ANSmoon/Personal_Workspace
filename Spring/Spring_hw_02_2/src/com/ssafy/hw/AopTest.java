package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) throws ApplicationException {
		// 자유 작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		User user = context.getBean("adminUser", User.class);
		User user1 = context.getBean("generalUser", User.class);
		System.out.println("*****1.General User");
		user1.useApp();
		System.out.println("*****2.Admin User");
		try {
			user.useApp();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}