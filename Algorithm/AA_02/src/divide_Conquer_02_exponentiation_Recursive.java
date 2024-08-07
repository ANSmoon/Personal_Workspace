
public class divide_Conquer_02_exponentiation_Recursive {
	public static void main(String[] args) {
		int C = 2;
		int N = 20;

		System.out.println(pow(C, N));
	}

	public static int pow(int C, int N) {
		if (N == 1)
			return C;

		// 재귀부분 : 짝수와 홀수 구분
		if (N % 2 == 0) { // 지수가 짝수 일때는 그대로 나누면 된다.
			return pow(C, N / 2) * pow(C, N / 2);
		} // 지수가 홀 수 일때는 하나 뺀 후 나눈다음 마지막에 하나더 곱해준다.
		return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2) * C;
	}

	public static int pow2(int C, int N) {
		if (N == 1)
			return C;
		int tmp;
		// 재귀부분 : 짝수와 홀수 구분
		if (N % 2 == 0) { // 지수가 짝수 일때는 그대로 나누면 된다.
			tmp = pow(C, N / 2);
			return tmp * tmp;
		} // 지수가 홀 수 일때는 하나 뺀 후 나눈다음 마지막에 하나더 곱해준다.
		tmp = pow(C, (N - 1) / 2);
		return tmp * tmp * C;
	}

	public static int pow3(int C, int N) {
		if (N == 1)
			return C;

		int tmp = pow(C, N / 2);
		// 재귀부분 : 짝수와 홀수 구분
		if (N % 2 == 0) { // 지수가 짝수 일때는 그대로 나누면 된다.
			return tmp * tmp;
		} // 지수가 홀 수 일때는 하나 뺀 후 나눈다음 마지막에 하나더 곱해준다.
		return tmp * tmp * C;
	}
}
