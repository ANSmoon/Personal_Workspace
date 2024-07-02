/*
 * Author : 문범수
 * Date : 2024-03-15
 * subject : 
 * page : https://www.acmicpc.net/problem/1012
 * main : DP
 * issue : 
 * name : no_9095.java
 * duration : m
 * no : 9095
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_9095 {
	public static int N, result, total, cnt;
	public static int[] arr = { 1, 2, 3 };

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(reader.readLine());
		for (int i = 0; i < total; i++) {
			result = 0;
			N = Integer.parseInt(reader.readLine());
			result = calculate(N);
			System.out.println(result);
		}

	}

	public static int calculate(int N) {
		if (N == 1)
			return 1;
		if (N == 2)
			return 2;
		if (N == 3)
			return 4;

		int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[N];
	}
}
