package test07_polymorphism;

public class Student extends Person {
    String major;
    
    public Student() {
    }
    
    
    public Student(String name, int age, String major) {
        super(name, age); // 가장 첫 줄에 와야 함.
        this.major = major;
    }
    

    public void study() {
        System.out.println("공부를 한다.");
    }
}
