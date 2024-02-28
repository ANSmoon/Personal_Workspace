package class05;

public class Person2 {
	String name;
	int age;
	String hobby;

	// 생성자 : 클래스명과 일치,
	// 반환형이 없다
	
	Person2(){
		
	}

	// 파라미터가 있는 생성자 => 멤버 변수 초기화에 사용
	// this는 멤버변수와 파라미터를 구분하기 위해 사용
	Person2(String name, int age, String hobby) {
		// this. 객체가 가지고 있는
		// 자신의 멤버 변수에 접근
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	
	Person2(String n, int x){
//		name = n;
//		age = x;
//		hobby = "Starcraft";
		//this()를 첫줄에 사용하면, 다른 생성자 호출 가능
		this(n,x, "Starcraft");
	}
	
	void info() {
		// 멤버 method => 멤버 변수에 바로 접근 가능
		System.out.println("이름은 " + name + "이고, 나이는 " + age + "세 취미는 " + hobby + "입니다.");
	}
	
	
	
}
