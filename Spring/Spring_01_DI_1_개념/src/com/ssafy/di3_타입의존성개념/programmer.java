package com.ssafy.di3_타입의존성개념;

public class programmer {
	private Computer computer; // interface 선언

	// 기본 생성자 필요
	public programmer() {
	}
	
	// 객체 생성 의존성 제거
	public programmer(Computer computer) {
		// 직접 생산하는 것이 아닌, 컴퓨터를 인자로 받아 제공
		// new를 사용할 필요 X
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발");
	}
	
}
