/*
 * Author : 문범수
 * Date : 2024-03-26
 * subject : 
 * main : 재귀함수 및 방문배열 초기화
 * issue : 탐색 범위 설정 오류
 * name : cheeze_thief.java
 * duration : 60m
 * CodeNo : 7733
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cheeze_thief {
	static int result, N, MAX, BEST, LOW;
	static int[][] matrix;
	static boolean[][] visited;
	static StringTokenizer token;
	static int[] dr = {-1, 0, 1, 0 }; // 상, 우, 하, 좌 4가지 방향 탐색
	static int[] dc = {0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			N = Integer.parseInt(reader.readLine());
			matrix = new int[N][N];
			result = 0;
			BEST = 0;
			MAX = 0;
			LOW = 100;

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					if (matrix[i][j] >= BEST) { // 최고 맛
						BEST = matrix[i][j];
					}
					if(matrix[i][j] <= LOW) { // 최저 맛
						LOW = matrix[i][j];
					}
				}
			}
			
			// 각 날짜별로 dfs 시행
			for (int k = LOW; k < BEST; k++) {
				result = 0;
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 방문하지 않았다면 감염 시작 && 행렬 숫자가 날짜보다 큰 경우
						if (!visited[i][j] && matrix[i][j] > k) {
							result++;
							dfs(i, j, k);
						}
					}
				}
				// 해당 날자동안의 result와 max값 비교 후 큰 값 삽입
				MAX = Math.max(MAX, result);
			}
			System.out.println("#" + index + " " + MAX);
		}
	}

	// 구역을 감염시킬 메소드
	static void dfs(int x, int y, int day) {
		visited[x][y] = true;
		
		// 3방 탐색
		for (int k = 0; k < 4; k++) {
			int row = x + dr[k];
			int col = y + dc[k];
			if (row >= 0 && row < N && col >= 0 && col < N && !visited[row][col] && matrix[row][col] > day) {
				dfs(row, col, day);
			}
		}
	}
}