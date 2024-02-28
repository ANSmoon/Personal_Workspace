package test05_user_exception;

public class FruitNotFoundRuntimeException extends RuntimeException{
	public FruitNotFoundRuntimeException(String name) {
		super(name + "과일 없음..");
	}
}
