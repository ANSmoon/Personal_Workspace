package test05_object;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("Hong", 25);
        // p.
        
       
        Student st = new Student("Yang", 45, "Computer");
        // 생성자를 하나라도 정의를 하면.. 기본생성자를 안만들어준다!
        // st.
        
        st.eat();
        System.out.println(p.toString());
        
        System.out.println(st.toString()); // Object.toString() : 참조값
        
        Student st2 = new Student("Yang", 45, "Computer");
        
        System.out.println(st == st2);
        System.out.println(st.equals(st2));
        
    }
}
