package test05_user_exception;

// Exception을 상속 받으면 : CheckedException
// RuntimeException 상속 : UncheckedException

public class FruitNotFoundException extends Exception{
	
	// 생성자
	public FruitNotFoundException(String name) {
		super(name + "에 해당하는 과일은 없다...");
		// 문자열을 넣어 => error message.
	}
}
