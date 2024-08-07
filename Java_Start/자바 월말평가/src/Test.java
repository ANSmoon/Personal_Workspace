/*
author : 문범수
date : 2024-01-29
subject : class 설계
name : Test.java
*/

public class Test {
	public static void main(String[] args) {

		Restaurant restaurant = Restaurant.getInstance();		
		
		restaurant.addMenu(new Food(1, "피자", 1200, 20000));
		restaurant.addMenu(new Food(2, "치킨", 1500, 18000));
		restaurant.addMenu(new Food(3, "샐러드", 500, 15000));
		
		restaurant.printMenu();
		
		int price = restaurant.howMuch("피자");
		// test code
		int price1 = restaurant.howMuch("치킨");
		int price2 = restaurant.howMuch("샐러드");
		
		System.out.println(price);
		// test code
		System.out.println(price1);
		System.out.println(price2);
		
	}
}
