package test05_user_exception;

public class UserExceptionTest {

	public static String[] fruits;

	public static void main(String[] args) {

		fruits = new String[] { "사과", "사과", "오렌지", "토마토" };

		boolean result = eatFruit("사과");
		System.out.println(result);
		
		result = eatFruit("사과");
		System.out.println(result);
		
		result = eatFruit("사과");
		System.out.println(result);
		if(result == false) {
			System.out.println("대처 코드");
		}	
	}
	
	// 항상 실행결과를 true / false 확인해야 한다.
	// 어떤 이유인지 알 수 없다.
	// 변수가 따로 있어야 되고, 매번 체크
	// try ~ catch 문 쓸수 없고, if 문을 복잡하게 써야한다.
	
	
	
	// 예외 처리를 하지 않는다면..
	// 성공했다면 true 반환 or false
	public static boolean eatFruit(String name) {
		for (int i = 0; i < fruits.length; i++) {
			if (name.equals(fruits[i])) {
				fruits[i] = null;
				System.out.println(name + "(을)를 먹었습니다.");
				return true;
			}
		}
		return false;
	}

}
