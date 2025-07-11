package com.multicampus.biz.user;

import lombok.Data;

// VO(Value Object) : USERS 테이블의 하나의 ROW와 매핑되는 클래스
@Data
public class UserVO { 
	// private 멤버 변수 선언
	private String id;
	private String password;
	private String name;
	private String role;	
}









