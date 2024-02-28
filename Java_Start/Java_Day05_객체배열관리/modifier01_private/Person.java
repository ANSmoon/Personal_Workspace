package modifier01_private;

public class Person {
    // private : 클래스 내에서만 사용할 수 있음.
    // 자바에서 코딩은  class 단위로 이루어짐.
    private String name;
    private int age;
    
    public void info() {
        System.out.printf("이름: %s, 나이: %d\n", name, age);
    }
}
