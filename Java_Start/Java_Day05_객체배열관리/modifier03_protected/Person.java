package modifier03_protected;

public class Person {
    // protected -> 같은 패키지 접근 가능
    //          -> 패키지가 달라도 상속 받으면 접근 가능
    protected String name;
    protected int age;
    
    public void info() {
        System.out.printf("이름: %s, 나이: %d\n", name, age);
    }
}
