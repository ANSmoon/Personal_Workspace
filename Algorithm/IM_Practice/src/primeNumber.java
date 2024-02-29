/*
 * Author : 문범수
 * Date : 2024-02-29
 * subject : primeNumber 구하기
 * main : 재귀함수
 * issue : 
 * name : primeNumber.java
 * duration : m
 * CodeNo : 4689
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class primeNumber {
	static StringTokenizer token;
	static int A, B, D, ans;
	static boolean pass, contain;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		token = new StringTokenizer(reader.readLine());
		D = Integer.parseInt(token.nextToken());
		A = Integer.parseInt(token.nextToken());
		B = Integer.parseInt(token.nextToken());
		int index = 1;

		while (index <= total) {
			ans = 0;
			for (int i = A; i <= B; i++) {
				pass = false;
				contain = false;
				if (A != 2 && A % 2 == 0) {
					continue;
				}
				for (int j = 2; j < A / 2; j++) {
					if (A % j == 0) {
						pass = true;
						break;
					}
				}
				if (pass) {
					continue;
				}
				while (!contain) {
					if (A % 10 == D) {
						contain = true;
						ans++;
						break;
					}
					A /= 10;
					if (A < 10) {
						break;
					}
				}
			}

			System.out.println("#" + index + " " + ans);
			index++;
		}

	}

}
