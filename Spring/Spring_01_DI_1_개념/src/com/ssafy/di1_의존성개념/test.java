package com.ssafy.di1_의존성개념;

public class test {
	public static void main(String[] args) {
		// programmer가 desktop에 대한 의존성을 가지고 있음.
		programmer p = new programmer();
		
		// 스프링 컨테이너가 이러한 일을 수행
		p.coding();
	}
}