package test03_super;

public class Student extends Person {
    
    String major;
    
    public Student(String name, int age, String major) {
    	super(name, age); // 부모클래스의 생성자 호출. Student(name, age);
    	this.major = major;
    	System.out.println("Student의 생성자입니다.");
    }
    
    
    public void study() {
        System.out.println("공부를 한다.");
        super.eat(); // 명시적으로 부모의 메서드를 호출하는데 사용가능.
        // super.name; // 부모의 멤버변수.
    }
}
