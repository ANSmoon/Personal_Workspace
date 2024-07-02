/*
 * Author : 문범수
 * Date : 2024-02-29
 * subject : primeNumber 구하기
 * main : 재귀함수
 * issue : 시간초과
 * name : primeNumber.java
 * duration : 80m
 * CodeNo : 4689
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class primeNumber {
	static StringTokenizer token;
	static int A, B, D, ans;
	static int[] arr;
	static boolean contain;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			D = Integer.parseInt(token.nextToken());
			A = Integer.parseInt(token.nextToken());
			B = Integer.parseInt(token.nextToken());
			ans = 0;
			arr = new int[B+1];
			for(int i = 2; i <= B; i++) {
				arr[i] = i;
			}
			
			for(int i = 2; i <= Math.sqrt(B); i++) {
				for(int j = i*i; j <= B; j = j + i) {
					arr[j] = 0;
				}
			}
			
			for(int i = A; i < arr.length; i++) {
				contain = false;
				if(arr[i] > 0) {
					while(!contain) {
						if(arr[i] % 10 == D) {
							contain = true;
							ans++;
							break;
						}
						if(arr[i] < 10) {
							break;
						}
						arr[i] /= 10;
					}
				}
			}

			System.out.println("#" + index + " " + ans);
			index++;
		}

	}

}
