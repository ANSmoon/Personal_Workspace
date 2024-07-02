package modifier04_public.pkg;

import modifier04_public.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        // 다른 패키지에서도 접근 가능.
        p.age = 10;
        p.name = "Yang";
        p.info();// public은 접근 가능
        
    }
}
