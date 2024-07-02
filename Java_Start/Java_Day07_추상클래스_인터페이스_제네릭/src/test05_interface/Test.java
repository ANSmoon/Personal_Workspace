package test05_interface;

public class Test {
	public static void main(String[] args) {
		// 인터페이스의 모든 멤버변수는 static final
		
		System.out.println(MyInterface.MEMBER1);
		System.out.println(MyInterface.MEMBER2);
		
		
		// 객체 생성
		MyClass mc = new MyClass();
		mc.method1();
		mc.method2();
		
		// 해당 객체가 그 인터페이스를 구현했다면,
		// 인퍼페이스 참조형 type으로 활용 가능
		
		MyInterface mi = mc;
		MyInterface mi2 = new MyClass();
	}
}
