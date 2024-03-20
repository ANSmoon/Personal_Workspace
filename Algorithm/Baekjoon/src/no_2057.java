/*
 * Author : 문범수
 * Date : 2024-03-17
 * subject : N!은 N - 1 까지의 팩토리얼 합보다 작다!
 * page : https://www.acmicpc.net/problem/2057
 * main : DP, 내림차순으로 팩토리얼 값을 더해줘야 모든 경우에 대해서 값을 구할 수 있다.
 * issue : 순차적인 factorial의 합이 아닌 M개의 factorial 합이다.
 * name : no_2057.java
 * duration : 60m
 * no : 2057
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_2057 {
	static long[] arr = new long[21];
	static String result = "NO";

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(reader.readLine());

		// dp에 미리 factorial 값 저장
		arr[0] = arr[1] = 1;
		for (int i = 2; i <= 20; i++) {
			arr[i] = i * arr[i - 1]; // factorial 원리
		}

		if (N == 0) {
			System.out.println(result);
		} else {
			calculator(N);
		}
	}

	static void calculator(long N) {
		for (int i = 20; i >= 0; i--) {
			if (N >= arr[i]) {
				N -= arr[i];
			}
			if (N < 0) {
				break;
			}
		}
		if (N == 0) {
			result = "YES";
			System.out.println(result);
		} else {
			System.out.println(result);
		}
	}
}
