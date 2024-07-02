package test04_abstract_method;

// 추상 메서드를 하나라도 가지고 있다면,
// 클래스는 추상 메서드이다.
// 클래스에도 abstract 키워드를 붙여준다.

public abstract class Chef {
    String name;
    int age;
    String speciality;
    
    public void eat() {
        System.out.println("음식을 먹는다.");
    }
    
    // 부모크래스의 메서드를 삭제하는 것이 아니라
    // 추상 메서드로 만든다.
    // - 구현부만 삭제 => 세미콜론
    // - abstract 키워드를 붙인다.
    
    public abstract void cook();
}
