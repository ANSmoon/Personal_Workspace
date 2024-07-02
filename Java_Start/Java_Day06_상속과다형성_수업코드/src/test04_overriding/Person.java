package test04_overriding;

public class Person {
    String name;
    int age;
    
    // 
    public Person(String name, int age) {
    	// 생성자의 첫줄에는 super(); 생략되어 있다.
    	// super() : 부모생성자 호출 는 첫줄에 와야함.
    	// this() :자신의 다른생성자 호출, 를 사용한다면 this()는 첫줄에 와야함.
    	// => 둘중에 하나만 쓸 수 있다.
    	super(); // Object(); // 최종적으로 Object() 기본생성자를 호출하게 되어 있다.
    	this.name = name;
    	this.age = age;
    	System.out.println("Person의 생성자입니다.");
    }
    
    public void eat() {
        System.out.println("음식을 먹는다.");
    }
}
