package com.ssafy.di3_타입의존성개념;

public class test {
	public static void main(String[] args) {
		// 의존관계 역전
		
		// 스프링 컨테이너가 이러한 일을 수행
		desktop desktop = new desktop();
		Laptop laptop = new Laptop();
		
		
		programmer p = new programmer(desktop);
		programmer p2 = new programmer(laptop);

		p.coding();
		p2.coding();
	}
}
