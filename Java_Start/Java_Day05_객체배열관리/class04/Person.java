package class04;

public class Person {
	// static 변수
	// - 메서드 영역(클래스영역, static영역)에 메모리 할당
	// - 인스턴스 생성하기 전에 이미 클래스 로딩 시점에 메모리 할당됨
	// - 모든 인스턴스가 공유
	static int pCount; // 사람의 수를 세는 변수..
	
	// non-static 변수
	// 멤버 변수: 객체가 가지고 있는 변수(데이터)
    String name;
    int age;
    String hobby;
    
    // non-static 메서드
    // 메서드=> 클래스 안에 정의된 함수
    // 멤버 메서드 : 객체가 가지고 있는 메서드.
    // 객체 생성 후에, 객체를 통해서만 접근 가능.
    void info() {
    	// 멤버 변수에 바로 접근할 수 있다!!
    	System.out.println("이름은 "+name+"이고, 나이는 "+age+"세 취미는 "+hobby+"입니다.");
    }
    
    // static 메서드는 객체 생성 없이 호출 가능.
    static void hello() {
    	System.out.println("Hello static!");
    }
    
}
