public class divide_Conquer_01_exponentiation_iterate {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;

		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
	}

	// 재귀를 쓰지않고 반복문으로 작성하는 법
	public static int pow(int C, int N) {
		int result = 1;
		for (int i = 1; i <= N; i++) {
//			result *= C;
			result = result * C;
		}
		return result;
	}

	// 재귀함수로구현 => 짝수와 홀수 구분하지 않고 진행
	public static int pow2(int C, int N) {
		if (N == 1)
			return C;
		return C * pow2(C, N - 1);

	}
}
