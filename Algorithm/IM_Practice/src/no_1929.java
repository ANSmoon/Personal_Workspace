/*
 * Author : 문범수
 * Date : 2024-03-13
 * subject : 소수 구하기
 * page : https://www.acmicpc.net/problem/1929
 * main : 에라토스테네스의 체
 * issue : 출력 시작 위치가 잘못되었음
 * name : no_1929.java
 * duration : 10m
 * no : 1929
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no_1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[] arr = new int[M + 1];
		for (int i = 2; i <= M; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(M); i++) {
			for (int j = i * i; j <= M; j = j + i) {
				arr[j] = 0;
			}
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= N) {
				System.out.println(arr[i]);
			}
		}
	}
}
