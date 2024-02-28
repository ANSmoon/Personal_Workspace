// Author : 문범수
// Date : 2024-01-18
// duration : 20m
// name : 객체 생성 연습 Lv3
// subject : 클래스와 객체

package homework;

public class Person {
	String name;
	int age;
	double height;
	String hobby;
	
	Person(){}
	Person (String name, int age, double height, String hobby){
		this.name = name;
		this.age = age;
		this.height = height;
		this.hobby = hobby;
	}
	
	void showInformation() {
		System.out.printf("저의 이름은 %s입니다.\n",name);
		System.out.printf("저의 나이는 %d입니다.\n",age);
		System.out.printf("저의 이름은 %.1f입니다.\n",height);
		System.out.printf("저의 이름은 %s입니다.\n",hobby);
	}
}
