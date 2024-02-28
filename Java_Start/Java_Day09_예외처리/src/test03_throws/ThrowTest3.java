package test03_throws;

// CheckedException
// - 컴파일 시 예외처리 강제
// - 빨간 줄 => throws해서 위임 가능
//         => 직접처리(try - catch)를 하지 않는다면 throws 필요
public class ThrowTest3 {
	public static void main(String[] args) throws ClassNotFoundException{
		method(); // 결국 예외 처리 x
	}

	public static void method() throws ClassNotFoundException {
		// 호출한 곳에서 다시 처리하거나, 위임
//		method2();
		 try {
			method2();	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void method2() throws ClassNotFoundException {
		// 예외 처리 위임 => 호출한 곳에 위임함
		Class.forName("SSAFY"); // 'ssafy'라는 이름의 클래스를 로드!

		// 1. 직접 처리
		// 2. 간접 처리
	}
}
