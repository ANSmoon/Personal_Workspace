package com.ssafy.di2_객체의존성개념;

public class Programmer {
	private Desktop desktop;
	
	// 객체 생성 의존성 제거
	public Programmer(Desktop desktop) {
		// 직접 생산하는 것이 아닌, 컴퓨터를 인자로 받아 제공
		// new를 사용할 필요 X
		this.desktop = desktop;
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + "으로 개발");
	}
	
}
