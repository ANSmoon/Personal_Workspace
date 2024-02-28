package modifier05_getter_setter;

public class PersonTest {
    public static void main(String[] args) {
    	Person p = new Person();
    	
    	// p.name = "Yang"; // 멤버변수에는 직접 접근 불가
    	// 위의 방법이 할 수 있는 것은 값을 할당하는 것밖에 할 수 없음!!
    	// => 기타 로직(검증 로직)의 추가가 불가능하다.
    	p.setName("Yang");
    	// p.age = -10;
    	p.setAge(-10);
    	
    	System.out.println(p.getAge());
    }
}
