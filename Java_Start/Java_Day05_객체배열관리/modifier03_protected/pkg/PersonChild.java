package modifier03_protected.pkg;

import modifier03_protected.Person;

public class PersonChild extends Person {
    public static void main(String[] args) {
        PersonChild pc = new PersonChild();
        pc.name = "Park";
        pc.age = 20;
        // protected는 상속받으면 접근할 수 있다.
    }
}
