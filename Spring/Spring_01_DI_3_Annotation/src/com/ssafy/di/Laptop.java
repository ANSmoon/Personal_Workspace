package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
	// field name 작성
	// CPU, GPU, RAM, SSD etc..

	// 기본 생성자 자동 생성
	
	// 정보 반환
	public String getInfo() {
		return "Laptop";
	}

}
