/*
 * Author : 문범수
 * Date : 2024-03-20
 * subject : 적록색약인 사람의 행렬 따로 구현
 * page : https://www.acmicpc.net/problem/10026
 * main : DFS
 * issue : 효율적인 coding 필요함
 * name : no_10026.java
 * duration : 30m
 * no : 10026
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_10026 {
	static int N, result1, result2; // 1은 정상인 결과, 2는 적록색약 결과
	static char[][] matrix1, matrix2; // matrix1은 정상인, 2는 적록색약
	static boolean[][] visited1, visited2;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		matrix1 = new char[N][N];
		matrix2 = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		result1 = 0;
		result2 = 0;
		String str;

		// 적록색약인 matrix는 아예 green색을 red색으로 바꿔서 입력받는다.
		for (int i = 0; i < N; i++) {
			str = reader.readLine();
			for (int j = 0; j < N; j++) {
				matrix1[i][j] = str.charAt(j);
				if (matrix1[i][j] == 'G') {
					matrix2[i][j] = 'R';
				} else {
					matrix2[i][j] = matrix1[i][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					dfs(matrix1, visited1, i, j);
					result1++;
				}

				if (!visited2[i][j]) {
					dfs(matrix2, visited2, i, j);
					result2++;
				}
			}
		}
		System.out.println(result1 + " " + result2);
	}

	// 일반 사람용 dfs
	private static void dfs(char[][] matrix, boolean[][] visited, int x, int y) {
		// 탐방지역 방문처리
		visited[x][y] = true;
		tmp = matrix[x][y]; // 현재 구역 문자

		// 4방 탐색 진행
		for (int k = 0; k < 4; k++) {
			int row = x + dr[k];
			int col = y + dc[k];
			if (row >= 0 && row < N && col >= 0 && col < N && !visited[row][col] && matrix[row][col] == tmp) {
				dfs(matrix, visited, row, col);
			}
		}
	}
}
