import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test3_대전_04반_문범수 {
	static long N;
	static long result;
	static long dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			N = Long.parseLong(reader.readLine());
			result = 0;
			dp = new long[11];
			dp[0] = 0; // 더미 데이터
			dp[1] = 1; // 선 입력 데이터
			long low = 1;
			long high = N;
			long mid;

			// dp의 2번째가 중요하니 해당 값을 2부터 1000000000까지 입력한 후 목표치에 도달할 수 있는
			// 최초의 i가 정답이 된다.
			while (low <= high) {
				mid = (low + high) / 2;
				calculator();
				if(dp[10] >= N) {
					result = mid;
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			System.out.println("#" + index + " " + result);
		}
	}

	// dp를 계산하기 위한 method
	static void calculator() {
		for (int i = 3; i < 11; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
	}
}