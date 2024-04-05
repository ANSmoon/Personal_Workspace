import java.util.Arrays;
import java.util.Scanner;

public class fibonacci {
	static int[] memo; // 계산 값을 저장하기 위한 공간
	static {
		memo = new int[1000];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;

		// 여기서 직접 계산 가능
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println(fibo3(N));
		System.out.println(fibo2(N));
		System.out.println(fibo1(N));
		
		sc.close();
	}

	public static int fibo3(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static int fibo2(int n) {
		if (memo[n] == -1) { // 값이 구해지지 않았으면 재귀호출
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}
		return memo[n]; // 값이 구해져 있으면 값 반환
	}

	public static int fibo1(int n) {
//		if (n == 0) {
//			return 0;
//		}
//		if (n == 1) {
//			return 1;
//		}
		if (n < 2) { // 0과 1은 각각 0과 1을 반환하기 때문에
			return n;
		}

		return fibo1(n - 1) + fibo1(n - 2);
	}
}