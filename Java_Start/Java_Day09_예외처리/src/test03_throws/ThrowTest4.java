package test03_throws;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

class parent {
	public void method1() throws IOException {
		
	}

	public void method2() throws ClassNotFoundException {
		
	}
	
	public void method3() {}

}

// throwtest4는 parent의 자식
public class ThrowTest4 extends parent{
		@Override
		public void method1() throws FileNotFoundException{
		}
		
		// 자식은 부모가 던지는 예외보다 조상(상위) 예외를 던질 수 없다.
//		@Override
//		public void method2() throws Exception{	
//		}
		
		// 하위 클래스의 접근제어자 범위가 상위 클래스보다 크거나 같아야 한다.
		@Override
		public void method3() {};
}
