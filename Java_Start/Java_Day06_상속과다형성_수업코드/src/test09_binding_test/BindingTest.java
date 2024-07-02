package test09_binding_test;


class Parent {
    String x = "parent x";
    
    public void method() {
        System.out.println("parent method.");
    }
}

class Child extends Parent{
    String x = "child x";
    
    @Override
    public void method() {
        System.out.println("child method.");
    }
}

public class BindingTest {
    
    public static void main(String[] args) {
        Parent a = new Parent();
        Child b = new Child();
        
//        System.out.println(a.x);
//        a.method();
//        
//        System.out.println(b.x); // Hiding
//        b.method();	// Overriding
        
        
//        // 다형성
        Parent c = new Child();
        c.method(); // ? 자식의 행위를 하고 있는데..
        System.out.println(c.x); // ?부모의 멤버변수가 튀어나옴.

        
        // 실제 객체가 child이므로 행위는 child의 행위를 할것임
        // (부모클래스의 타입으로 참조한다 하더라도)
        // 부모클래스로 바라본다 하더라도.
        
        
        // 동적바인딩..
        
        // 실제 객체의 행위가 나온다! => 다형성
        // 멤버메서드는 => 부모의 관점으로 바라보더라도 자식에서 재정의한 행위가 발생.
        // 멤버변수는 다형성을 따르지 않는다 => 부모의 관점으로 바라보면
        // 부모의 것을 참조..
        
        
        
        
        
        
        
        
        
        
        
   
        
    }

}
