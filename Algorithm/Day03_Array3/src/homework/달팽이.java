/*
 * Author : 문범수
 * Date : 2024-01-31
 * subject : 순회탐색
 * name : Solution2.java
 * duration : 75m
 * CodeNo : 1954
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 달팽이 {
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		int x = 1;

		while (x <= total) {
			int size = Integer.parseInt(reader.readLine());

			// 전체 배열 생성
			int[][] arr = new int[size][size];
			cycle(arr);
			printArr(arr, x);
			x++;
		}
		reader.close();
	}

	// cycle을 도는 함수 설정
	// 총 4번을 돌도록 설정
	// 짝수일 때 홀수일 때 고려(?)
	public static void cycle(int[][] arr) {
		// 우, 하, 좌, 상 방향 설정

		// 입력값 설정
		int count = 1;
		int times = 0;

		// 시작 위치 설정
		int start_row = 0;
		int start_col = 0;

		// 한번의 cycle 구현
		// 크기가 짝수일 때 홀수일 때 구분
		// 시작위치는 1칸이 늘리면서 갱신 필요
		if (arr.length % 2 == 0) {
			while (times < arr.length / 2) {
				for (int i = start_col; i < arr.length && arr[start_row][i] == 0; i++) {
					arr[start_row][i] = count++;
					start_col = i;
				}
				start_row++;
				for (int i = start_row; i < arr.length && arr[i][start_col] == 0; i++) {
					arr[i][start_col] = count++;
					start_row = i;
				}
				start_col--;
				for (int i = start_col; i >= 0 && arr[start_row][i] == 0; i--) {
					arr[start_row][i] = count++;
					start_col = i;
				}
				start_row--;
				for (int i = start_row; i >= 0 && arr[i][start_col] == 0; i--) {
					arr[i][start_col] = count++;
					start_row = i;
				}
				start_col++;
				times++;
			}
		} else {
			while (times < (arr.length - 1) / 2) {
				for (int i = start_col; i < arr.length && arr[start_row][i] == 0; i++) {
					arr[start_row][i] = count++;
					start_col = i;
				}
				start_row++;
				for (int i = start_row; i < arr.length && arr[i][start_col] == 0; i++) {
					arr[i][start_col] = count++;
					start_row = i;
				}
				start_col--;
				for (int i = start_col; i >= 0 && arr[start_row][i] == 0; i--) {
					arr[start_row][i] = count++;
					start_col = i;
				}
				start_row--;
				for (int i = start_row; i >= 0 && arr[i][start_col] == 0; i--) {
					arr[i][start_col] = count++;
					start_row = i;
				}
				start_col++;
				times++;
			}
			arr[(arr.length - 1) / 2][(arr.length - 1) / 2] = count;
		}
	}

	public static void printArr(int[][] arr, int x) {
		System.out.println("#" + x);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
