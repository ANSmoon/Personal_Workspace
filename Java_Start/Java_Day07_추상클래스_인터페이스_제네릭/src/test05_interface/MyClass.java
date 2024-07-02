package test05_interface;

// 인터페이스는 항상 클래스에 의해 구현된다.
public class MyClass implements MyInterface {

	@Override
	public void method1() {
		System.out.println("method1");
		
	}

	@Override
	public void method2() {
		System.out.println("method2");
		
	}
	
}
