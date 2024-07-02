import java.util.Scanner;

public class changeOfCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt(); // 해당 거스름돈의 최소 동전 갯수를 구하고
		// 사용가능 동전 : 1원 / 4원 / 6원

		int[] dp = new int[money + 1];
		// dp[0] = 0 // 0원은 줄 수 없음

		for (int i = 1; i <= money; i++) {
			int minCnt = 987654321;
			// 1원을 작은 부분문제에 추가하겠다.
			minCnt = Math.min(minCnt, dp[i - 1] + 1);
			if(i >= 4) {
				minCnt = Math.min(minCnt, dp[i-4] + 1);
			}
			if(i >= 6) {
				minCnt = Math.min(minCnt, dp[i-6] + 1);
			}
			dp[i] = minCnt;
		}
		System.out.println(dp);

	}
}
