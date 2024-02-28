/*
 * Author : 문범수
 * Date : 2024-02-20
 * subject : for문 사용
 * main : 반복문 구현
 * issue : 2차원 배열을 쓰지 않으려 하니 오래걸림
 * name : pascal_Triangle.java
 * duration : 23m
 * CodeNo : 2005
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pascal_Triangle {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;


		while (index <= total) {
			int N = Integer.parseInt(reader.readLine());
			int[][] arr = new int[N + 1][N + 1]; // 윗줄 배열
			System.out.println("#" + index);
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					if (j == 0 || j == i - 1) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			index++;
		}
	}
}
