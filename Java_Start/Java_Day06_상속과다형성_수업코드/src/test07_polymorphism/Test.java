package test07_polymorphism;

public class Test {
    public static void main(String[] args) {

        // 다형성
    	// 조상클래스의 타입으로 자식 객체를 참조할 수 있다.
    	
        Student st = new Student();
        Person p = new Student(); // 실제 메모리에 생성된 객체는 Student이지만, Person으로 바라보겠다.
        Object obj = new Student(); // 실제 메모리에 생성된 객체는 Student이지만, Object로 바라보겠다.
        
//        st.
//        p.
//        obj.
        
        st.study();
        
        
        // Person에서 toString을 오버라이드 했음.
        Object o2 = new Object();
        Object o3 = new Person(); // 다형성
        // Object로 바라본다 하더라도! 실제 객체는 사람이다.
        // 메서드를 실행하면 사람의 행동을 한다.        
        
        System.out.println(o2.toString());
        System.out.println(o3.toString());
        
        // 부모클래스의 타입으로 자식 객체를 참조하더라도,
        // 실제 객체가 자식 클래스의 객체라면, 
        // 자식 클래스에서 오버라이드한 메서드가 실행된다.
        
      
    }
}
