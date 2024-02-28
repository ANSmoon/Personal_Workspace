package class04;

public class PersonTest {
    public static void main(String[] args) {
    	
    	// static 변수의 접근은
    	// 클래스 이름으로 바로 접근할 수 있다.
    	
    	Person.pCount = -1;
    	Person.hello(); // 객체 생성 없이, 클래스 이름으로 바로 접근했다 => static.
    	
    	
    	// 인스턴스는 힙 메모리에 생성된다.
    	// non-static은 객체 생성 후에만 접근 가능하다.
        Person p = new Person();
        p.age = 45;
        p.name= "Yang";
        p.hobby="Youtube";
        p.pCount = 10; // Person.pCount;
       
        Person p2 = new Person();
        p2.age = 25;
        p2.name= "Hong";
        p2.hobby="Golf";
        p2.pCount = 5;
        
        
    }
}
