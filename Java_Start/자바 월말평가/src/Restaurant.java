/*
author : 문범수
date : 2024-01-29
subject : class 설계
name : Restaurant.java
*/

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	// food 클래스를 List 형으로 menu 객체 생성
	List<Food> menu = new ArrayList<Food>();

	// 싱글톤 패턴 구현
	private static Restaurant instance = new Restaurant();

	// 외부 참조 방지
	private Restaurant() {
	}

	// instance 반환 접근 허용
	public static Restaurant getInstance() {
		return instance;
	}

	// menu List에 food 추가 구현 메소드
	public void addMenu(Food food) {
		menu.add(food);
	}
	
	// menu List에 추가된 food list 출력
	public void printMenu() {
		System.out.println(menu.toString());
	}

	// 해당 이름의 메뉴 가격 반환 구현 메소드
	int howMuch(String name) {
		int price = 0;
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getName().equals(name)) {
				price = menu.get(i).getPrice();
			}
		}
		return price;
	}
}
