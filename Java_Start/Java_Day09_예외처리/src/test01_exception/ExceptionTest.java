package test01_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int[] nums = {10};
		
		// UncheckedException
		// - 컴파일 시간에 확인 x -> 빨간 줄 x
		// - 실행 중에 발생
		// - 예외 처리를 강제하지 않음
		// - 예외 처리 : try ~ catch를 이용해 처리 가능
		System.out.println(nums[2]);
		
		// CheckedException
		// - 컴파일 시간에 확인 -> 빨간 줄
		// - 예외 처리를 강제
		// - 예외처리 방법 : try - catch를 사용해서 직접처리, throws를 선언해 예외처리 위임(간접처리)
//		Thread.sleep(1000);
		
		
	}
}
