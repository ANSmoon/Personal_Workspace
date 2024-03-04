/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 
 * main : 누적합 활용
 * issue : 이해문제
 * name : warp_Gate.java
 * duration : 33m
 * CodeNo : 7964
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class warp_Gate {
	static StringTokenizer token;
	static int ans, N, D, cnt;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			D = Integer.parseInt(token.nextToken());

			token = new StringTokenizer(reader.readLine());
			arr = new int[N];
			ans = cnt = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}

			for (int i = 0; i < N; i++) {
				if(arr[i] == 0) {
					cnt++;
				}
				if(cnt == D) {
					arr[i] = 1;
					cnt = 0;
					ans++;
				}
				if(arr[i] == 1) {
					cnt = 0;
					continue;
				}
			}
			System.out.println("#" + index + " " + ans);
			index++;
		}
	}
}
