package test02_inheritance;

// 추상 메소드가 없어도 abstract는 붙일 수 있고
// 객체 생성은 안된다.
public abstract class Chef {
    String name;
    int age;
    String speciality;
    
    public void eat() {
        System.out.println("음식을 먹는다.");
    }
    
    public void cook() {
        System.out.println("전공에 맞는 조리한다.");
    }
}
