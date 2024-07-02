/*
 * Author : 문범수
 * Problem : 자리를 사수하라
 * date : 2024 - 03 - 25
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_대전_04반_문범수 {
	static int total, result, sum, cnt, tmp;
	static int[][] person; // 사람들 정보 저장 배열
	static int[][] matrix; // 행렬
	static boolean[][] visited; // 방문처리
	static StringTokenizer token;
	static int[] dr = { -2, -1, -1, 0, 0, 1, 2, 1, 1, 0, 0, -1 }; // 행 탐색
	static int[] dc = { 0, 0, 1, 2, 1, 1, 0, 0, -1, -2, -1, -1 }; // 열 탐색

	static int[] dr1 = { -1, 0, 1, 0 }; // 행 4방 탐색
	static int[] dc1 = { 0, 1, 0, -1 }; // 열 4방 탐색

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			matrix = new int[9][9];
			visited = new boolean[9][9];

			// 정렬에 자리 위치 저장
			for (int i = 0; i < 9; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 9; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					if (matrix[i][j] != 0) {
						visited[i][j] = true;
					}
				}
			}

			cnt = Integer.parseInt(reader.readLine());
			person = new int[cnt][3];

			for (int i = 0; i < cnt; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 3; j++) {
					person[i][j] = Integer.parseInt(token.nextToken());
					// 0열 : M(견딜 수 있는 소음 크기)
					// 1열 : D(소음이 들리는 거리)
					// 2열 : S(자리에 앉았을 때 내는 소음의 크기
				}
			}

			tmp = 0;
			while (tmp < cnt) {
				first : for (int i = 1; i < 8; i++) {
					if (i % 2 == 0) { // 짝수 행일때는 순차 탐색
						for (int j = 1; j < 8; j++) {
							if (matrix[i][j] == 0 && !visited[i][j]) {
								sum = 0;
								if (person[tmp][1] == 1) { // 들을 수 있는 거리가 1이면 4방 탐색 진행
									for (int k = 0; k < 4; k++) {
										int row = i + dr1[k];
										int col = j + dc1[k];
										if (row >= 0 && row < 9 && col >= 0 && col < 9 && matrix[i][j] > 0) {
											sum += matrix[i][j];
										}
									}
									if (sum < person[tmp][0]) {
										matrix[i][j] = person[tmp++][2];
										visited[i][j] = true;
										result++;
										break first;
									}
								} else {
									for (int k = 0; k < 12; k++) {
										int row = i + dr[k];
										int col = j + dc[k];
										if (row >= 0 && row < 9 && col >= 0 && col < 9 && matrix[i][j] > 0) {
											sum += matrix[i][j];
										}
									}
									if (sum < person[tmp][0]) {
										matrix[i][j] = person[tmp++][2];
										visited[i][j] = true;
										result++;
										break first;

									}
								}
							}
						}
					} else { // 홀수 행일때는 역순 탐색
						for (int j = 7; j >= 1; j--) {
							if (matrix[i][j] == 0 && !visited[i][j]) {
								sum = 0;
								if (person[tmp][1] == 1) { // 들을 수 있는 거리가 1이면 4방 탐색 진행
									for (int k = 0; k < 4; k++) {
										int row = i + dr1[k];
										int col = j + dc1[k];
										if (row >= 0 && row < 9 && col >= 0 && col < 9 && matrix[i][j] > 0) {
											sum += matrix[i][j];
										}
									}
									if (sum < person[tmp][0]) {
										matrix[i][j] = person[tmp++][2];
										visited[i][j] = true;
										result++;
										break first;

									}
								} else {
									for (int k = 0; k < 12; k++) {
										int row = i + dr[k];
										int col = j + dc[k];
										if (row >= 0 && row < 9 && col >= 0 && col < 9 && matrix[i][j] > 0) {
											sum += matrix[i][j];
										}
									}
									if (sum < person[tmp][0]) {
										matrix[i][j] = person[tmp++][2];
										visited[i][j] = true;
										result++;
										break first;

									}
								}
							}
						}
					}
				}
			}
			if(result == 0) {
				result = -1;
			}
			System.out.println("#" + index + " " + result);
			index++;
		}
	}
}