/*
 * Author : 문범수
 * Date : 2024-02-16
 * subject : 완전탐색
 * main : 투 포인터 개념
 * issue : 반복문 logic 구현
 * name : flag.java
 * duration : 240m
 * CodeNo : 4613
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class flag {
	static int N; // 줄
	static int M; // 열
	static int[][] arr; // 색깔 갯수 저장
	static StringTokenizer token;
	static int sum;
	static String str;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			sum = 0;
			str = "";
			arr = new int[N][3];
			min = Integer.MAX_VALUE;

			// 각 줄별로 색깔 갯수 저장
			for (int i = 0; i < N; i++) {
				str = reader.readLine();
				for (int j = 0; j < M; j++) {
					if (str.charAt(j) == 'W') {
						arr[i][0]++;
					} else if (str.charAt(j) == 'B') {
						arr[i][1]++;
					} else {
						arr[i][2]++;
					}
				}
			}

			// 파랑 위치를 기준으로 위는 흰색 파랑 아래쪽은 파랑 빨강 영역 구분
			// 빨강이 1칸씩 내려가고, 파랑이 1칸씩 올라오는 반복문 구현
			// 파랑은 그 사이만 칠하면 된다.
			// two pointer 개념
			int temp = 0;
			for (int i = 0; i < N - 2; i++) { // 아래 최소 2칸은 확보 되어야 한다.
				for (int k = 0; k <= i; k++) {
					sum += M - arr[k][0]; // white 영역
					temp = sum;
				}
				for (int l = i + 1; l < N - 1; l++) { // 가운데 blue 색상 영역
					
					for(int m = i + 1; m <= l; m++) {
						sum += M - arr[m][1];
					}
					for (int j = l + 1; j < N; j++) { // red 색상 영역
						sum += M - arr[j][2];
					}
					min = Math.min(min, sum);
					sum = temp;
				}
				sum = 0;
			}
			// 첫번째 줄과 마지막 줄은 흰색 빨강색 고정
			System.out.println("#" + index + " " + min);
			index++;
		}
	}
}
