/*
author : 문범수
date : 2024-01-29
subject : class 설계
name : Food.java
*/

public class Food{
	// 외부 참조 방지 캡슐화
	private int id, calorie, price;
	private String name;
	
	// 생성자 선언
	public Food() {
	}
	
	// 매개변수 입력 생성자 선언
	public Food(int id, String name, int calorie, int price) {
		this.id = id;
		this.name = name;
		this.calorie = calorie;
		this.price = price;
	}
	
	// 각 인자에 접근할 수 있는 getter, setter 선언
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// override를 통한 toString 구현
	@Override
	public String toString() {
		return "Food [id=" + this.id + ", calorie=" + this.calorie + ", price=" + this.price + ", name=" + this.name + "]";
	}

	
}
