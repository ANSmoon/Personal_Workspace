package com.ssafy.hw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		// Spring 컨테이너로부터 UserDao 빈(bean)을 가져옴
		UserDao userDao = context.getBean(UserDao.class);

		// 사용자 생성
		User user = new User();
		user.setId("testuser");
		user.setPassword("password123");
		user.setName("Test User");
		userDao.insert(user); // 사용자 추가
		
		// 생성한 사용자 조회
		User retrievedUser = userDao.searchById("testuser");
		System.out.println("Retrieved User: " + retrievedUser);

		// Spring 컨테이너 종료
		((GenericXmlApplicationContext) context).close();
	}
}