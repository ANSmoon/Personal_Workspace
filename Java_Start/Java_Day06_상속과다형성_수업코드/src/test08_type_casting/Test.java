package test08_type_casting;

public class Test {
    public static void main(String[] args) {
        // 기초자료형의 형변환.
        // - 묵시적 형변환, 명시적 형변환.
        
        // 객체의 형변환.
        // 1. 묵시적 형변환 : 자손 객체의 타입 => 조상 타입
        Person p =new Person();
        Object obj = p;
        Student st = new Student();
        Object obj2 = st;
        
   
        
        // 2. 명시적 형변환 : 조상 타입 => 자손 타입 (에러 발생 가능)
        Person p2 = (Person)obj;
        Student st2 = (Student)obj2;
//        p2.eat();
//        st2.study();
//        
        Student st3 = (Student) p;
        st3.study();
        //Person객체를 Student로 바라본다 하더라도
        // 메모리에 study()가 없으므로 에러.
        

        // instanceof 연산자를 사용하면 해당 객체가 그 클래스의 인스턴스인지
        // 확인할 수 있음
        // 객체 instanceof 클래스
        // 클래스가 자신클래스이거나 부모클래스이면 true
        // 사람은 사람이다 ok
        // 사람은 동물이다 ok
        
        
        if(obj instanceof Person)
            ((Person)obj).eat();

        
        if(obj2 instanceof Student)
            ((Student)obj2).eat();

        
        if(obj2 instanceof Person)
            ((Person)obj2).eat();
        
        
        
        
    }
}
