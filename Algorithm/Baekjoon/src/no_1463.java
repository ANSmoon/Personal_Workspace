/*
 * Author : 문범수
 * Date : 2024-03-10
 * subject :
 * page : https://www.acmicpc.net/problem/1463
 * main : DP
 * issue : 나누는 수 설정 실수
 * name : no_1463.java
 * duration : 30m
 * no : 1463
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_1463 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		dp = new int[1000001];
		dp[2] = 1;
		dp[3] = 1;
		calculator(N);
		System.out.println(dp[N]);
	}

	static void calculator(int N) {
		for (int i = 4; i <= N; i++) {
			if (i % 6 == 0) {
				dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}
	}
}