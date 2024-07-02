package modifier04_public;

public class Person {
    // public -> 같은 패키지 접근 가능
    //          -> 패키지가 달라도 접근 가능(어디서나 접근 가능.)
    public String name;
    public int age;
    
    public void info() {
        System.out.printf("이름: %s, 나이: %d\n", name, age);
    }
}
