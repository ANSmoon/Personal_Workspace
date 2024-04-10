/*
 * Author : 문범수
 * Date : 2024-04-10
 * subject : 순열
 * page : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
 * main : 각 위치에서 넘길수 있는 방안 구현
 * issue : 
 * name : specialMagnetic.java
 * duration : 100m
 * CodeNo : 4013
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class specialMagnetic {
	static int result, K, now, dir; // K : 회전 횟수
	static int[][] magnetics; // 4개의 자석 정보 입력
	static StringTokenizer token;
	static int[] tmp = new int[8];
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			result = 0;
			magnetics = new int[4][8];

			token = new StringTokenizer(reader.readLine());
			K = Integer.parseInt(token.nextToken());

			// 자석 정보 입력
			// 0 : N, 1 : S
			for (int i = 0; i < 4; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 8; j++) {
					magnetics[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			// 회전 자석의 위치 및 방향 입력
			// 1 : 오른쪽, -1 : 왼쪽
			for (int i = 0; i < K; i++) {
				token = new StringTokenizer(reader.readLine());
				arr = new int[4];
				visited = new boolean[4];
				now = Integer.parseInt(token.nextToken()) - 1;
				dir = Integer.parseInt(token.nextToken());
				arr[now] = dir;
				rotate(now, dir);
				rotation(arr);
			}
			totalSum();

			System.out.println("#" + index + " " + result);
		}

	}

	// 회전 메소드
	// 자석 2번과 6번 위치의 정보를 고려해서 회전시켜야 함.
	// 0 : 시계방향 / 1 : 반시계방향 : -1
	static void rotate(int index, int direction) {
		visited[index] = true;

		if (index == 0 && !visited[index + 1]) {
			if (magnetics[index][2] != magnetics[index + 1][6]) {
				arr[index + 1] = arr[index] * (-1);
				rotate(index + 1, direction);
			}
		} else if (index == 3 && !visited[index - 1]) {
			if (magnetics[index][6] != magnetics[index - 1][2]) {
				arr[index - 1] = arr[index] * (-1);
				rotate(index - 1, direction);
			}
		} else if (index > 0 && index < 3) {
			if (!visited[index + 1]) {
				if (magnetics[index][2] != magnetics[index + 1][6]) {
					arr[index + 1] = arr[index] * (-1);
					rotate(index + 1, direction);
				}
			}
			if (!visited[index - 1]) {
				if (magnetics[index][6] != magnetics[index - 1][2]) {
					arr[index - 1] = arr[index] * (-1);
					rotate(index - 1, direction);
				}
			}
		}
	}

	// 배열을 회전시키는 메소드
	static void rotation(int[] arr) {
		for (int j = 0; j < 4; j++) {
			if (arr[j] == 1) {
				// 시계방향 회전
				int last = magnetics[j][7];
				for (int i = 0; i < 7; i++) {
					tmp[i + 1] = magnetics[j][i];
				}
				tmp[0] = last;
				for (int i = 0; i < 8; i++) {
					magnetics[j][i] = tmp[i];
				}
			} else if (arr[j] == -1) {
				// 반시계방향 회전
				int first = magnetics[j][0];
				for (int i = 7; i > 0; i--) {
					tmp[i - 1] = magnetics[j][i];
				}
				tmp[7] = first;
				for (int i = 0; i < 8; i++) {
					magnetics[j][i] = tmp[i];
				}
			}
		}
	}

	// 합계 메소드
	static void totalSum() {
		if (magnetics[0][0] == 1) {
			result += 1;
		}
		if (magnetics[1][0] == 1) {
			result += 2;
		}
		if (magnetics[2][0] == 1) {
			result += 4;
		}
		if (magnetics[3][0] == 1) {
			result += 8;
		}
	}
}