package test04_overriding;

public class Test {
    public static void main(String[] args) {
//        Person p = new Person("Hong", 25);
        // p.
        
       
        Student st = new Student("Yang", 45, "Computer");
        // 생성자를 하나라도 정의를 하면.. 기본생성자를 안만들어준다!
        // st.
        
        st.eat();
        
        
    }
}
