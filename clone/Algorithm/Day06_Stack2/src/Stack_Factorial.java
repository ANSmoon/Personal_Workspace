
public class Stack_Factorial {
//	static int count = 0;
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}

	public static int factorial(int n) {
		// 예외 처리 안할 시 stack 호출 횟수 확인[에러나는 이유 : stack overflow]
//		System.out.println(count++);
		if (n <= 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}
}
