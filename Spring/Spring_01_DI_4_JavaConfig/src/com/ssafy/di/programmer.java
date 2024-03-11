package com.ssafy.di;

public class programmer {
	private Computer computer; // interface 선언

	// 기본 생성자 필요
//	public programmer() {
//	}
	
	// 생성자 주입
	public programmer(Computer computer) {
		this.computer = computer;
	}
	
	// 설정자 주입 (setter 사용)
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
//	// method 주입 (여러개를 동시에 주입)
//	많이 사용되지 않으므로 몰라도 된다.
//	public void init(desktop computer, Keyboard keyboard) {
//		this.computer = computer;
//		this.keyboard = keyboard;
//	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발");
	}
	
}
