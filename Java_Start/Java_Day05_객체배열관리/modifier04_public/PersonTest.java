package modifier04_public;

// 다른패키지에 있는 클래스는 import
//import modifier04_public.pkg.Person;


public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        // 같은 패키지에서 접근 가능.
        p.age = 10;
        p.name = "Yang";
        p.info();// public은 접근 가능
        
    }
}
