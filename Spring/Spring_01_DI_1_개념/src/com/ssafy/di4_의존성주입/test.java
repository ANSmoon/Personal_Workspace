package com.ssafy.di4_의존성주입;

public class test {
	public static void main(String[] args) {

		desktop desktop = new desktop();
		Laptop laptop = new Laptop();
		
		// 생성자 주입
		programmer p = new programmer(desktop);
		p.coding();
		
		programmer p2 = new programmer();
		p2.setComputer(laptop);
		p2.coding();
	}
}