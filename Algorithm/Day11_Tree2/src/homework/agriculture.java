/*
 * Author : 문범수
 * Date : 2024-02-16
 * subject : 조건 탐색
 * main : 피라미드 형태 순회 탐색 => two point 방식
 * issue : 띄어쓰기 없는 입력
 * name : agriculture.java
 * duration : 30m
 * CodeNo : 2805
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class agriculture {
	static int N;
	static int[][] arr;
	static int sum;
	static int left;
	static int right;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			
			N = Integer.parseInt(reader.readLine());
			arr = new int[N][N];
			left = N / 2;
			right = N / 2;
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				str = reader.readLine(); 
				for (int j = 0; j < N; j++) { // 입력 먼저
					arr[i][j] = str.charAt(j) - '0';
				}

				if (i < N / 2) { // 중간까지는 양쪽으로 늘려가가기
					for (int j = left; j <= right; j++) {
						sum += arr[i][j];
					}
					left--;
					right++;
				} else if (i >= N / 2) { // 중간이후부터는 양쪽에서 줄어들기
					for (int j = left; j <= right; j++) {
						sum += arr[i][j];
					}
					left++;
					right--;
				}
			}
			System.out.println("#" + index + " " + sum);
			index++;
		}

	}
}
