package com.ssafy.di2_객체의존성개념;

public class test {
	public static void main(String[] args) {
		// 의존관계 역전
		// 스프링 컨테이너가 이러한 일을 수행
		Desktop desktop = new Desktop();
		Programmer p = new Programmer(desktop);

		p.coding();
	}
}
