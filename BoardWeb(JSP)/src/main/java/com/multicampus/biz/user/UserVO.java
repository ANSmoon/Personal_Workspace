package com.multicampus.biz.user;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import lombok.Data;

// VO(Value Object) : USERS 테이블의 하나의 ROW와 매핑되는 클래스
@Data
public class UserVO implements HttpSessionBindingListener { 
	// private 멤버 변수 선언
	private String id;
	private String password;
	private String name;
	private String role;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(id + "에 해당하는 UserVO 객체가 세션에 등록됨");
	}
	
//	@Override
//	public void valueUnbound(HttpSessionBindingEvent event) {
//
//	}
}









