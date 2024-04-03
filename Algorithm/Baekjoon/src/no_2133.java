/*
 * Author : 문범수
 * Date : 2024-04-03
 * subject : 가능한 가짓 수 파악
 * page : https://www.acmicpc.net/problem/2133
 * main : DP
 * issue : 정해진 규칙 파악 실패
 * name : no_2133.java
 * duration : 60m
 * no : 2133
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		int result = 0;

		if (N % 2 == 0) { // n이 짝수인 경우에만 모든 타일을 채울 수 있다.
			int[] dp = new int[N + 1]; // N <= 30
			dp[0] = 1;
			dp[2] = 3;
			
			for (int i = 4; i <= N; i += 2) {
				dp[i] = dp[i-2] * 3;
				for(int j = i - 2; j > 0; j -= 2) {
					dp[i] += 2 * dp[j - 2];
				}
			}
			result = dp[N];
		}
		System.out.println(result);
	}
}