package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class test {
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("1번");
		programmer p = (programmer) context.getBean("programmer");
		
		// 기본 설정은 getBean 에서 생성하는 것이 아닌 컨테이너를 빌드할 때 bean 들이 생성된다.
		desktop d = context.getBean("desktop", desktop.class);
		p.setComputer(d);
		
		
		System.out.println("2번");
		p.coding();
		
		desktop d2 = context.getBean("desktop", desktop.class);
		System.out.println(d == d2); // true : container는 기본적으로 singleton으로 관리한다.
	}
}