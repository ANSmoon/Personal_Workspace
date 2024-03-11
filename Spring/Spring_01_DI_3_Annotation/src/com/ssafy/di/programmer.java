package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "p")
public class programmer {
//	@Autowired
	// filed Autowired는 최대한 지양하도록 하자.
	private Computer computer; // interface 선언

	// 기본 생성자 필요
//	public programmer() {
//	}
	
	// 생성자 주입
//	@Autowired
//	public programmer(Computer computer) {
//		this.computer = computer;
//	}
	
	// 설정자 주입 (setter 사용)
	@Autowired
	public void setComputer(@Qualifier("laptop") Computer computer) {
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
