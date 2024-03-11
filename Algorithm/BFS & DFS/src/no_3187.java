/*
 * Author : 문범수
 * Date : 2024-03-11
 * subject : 
 * page : https://www.acmicpc.net/problem/3187
 * main : DFS
 * issue : 
 * name : no_3187.java
 * duration : m
 * no : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no_3187 {
	static int N, M, cnt_v, cnt_k, result_v, result_k;
	static char[][] matrix;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		matrix = new char[N][M];
		visited = new boolean[N][M];
		result_v = 0;
		result_k = 0;

		for (int i = 0; i < N; i++) {
			String str = reader.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = str.charAt(j);
				if(matrix[i][j] == '#') {
					visited[i][j] = true;
				}
			}
		}

		// 모든 지점을 돌면서 각 지역별 살아있는 동물 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					cnt_k = 0;
					cnt_v = 0;
					
					// 여기 부분이 필요했음
					// dfs 시작하면 행과 열을 더하고 시작하기 때문에 문제가 있었음
					if(matrix[i][j] == 'v') {
						cnt_v++;
					}else if(matrix[i][j] =='k') {
						cnt_k++;
					}
					dfs(i, j);
					if(cnt_k == 0 && cnt_v == 0) {
						continue;
					}
					
					if (cnt_k > cnt_v) {
						result_k += cnt_k;
					} else{
						result_v += cnt_v;
					}
				}
			}
		}
		System.out.println(result_k + " " + result_v);
	}

	// dfs 실행
	static void dfs(int x, int y) {
		visited[x][y] = true;

		// 탐색할때 맨 처음 위치는 탐색을 안하게 된다!!!
		for (int k = 0; k < 4; k++) {
			int row = x + dr[k];
			int col = y + dc[k];

			// # 지역만 아니면 일단 들어간다.
			if (row >= 0 && col >= 0 && row < N && col < M && !visited[row][col]) {
				if (matrix[row][col] == '.') {
					dfs(row, col);
				} else if (matrix[row][col] == 'k') {
					cnt_k++;
					dfs(row, col);
				} else{
					cnt_v++;
					dfs(row, col);
				}
			}
		}
	}
}