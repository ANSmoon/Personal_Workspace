/*
 * Author : 문범수
 * Date : 2024-03-07
 * subject : 각 지점별로 갈 수 있는 곳을 체크한 뒤 영역 갯수를 구한다.
 * page : https://www.acmicpc.net/problem/2468
 * main : dfs
 * issue : 하나씩 이동하는 형태가 아니라 동시에 퍼져나가야 한다.
 * visited 초기화 문제
 * name : no_2468.java
 * duration : 100m
 * no : 2468
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no_2468 {
	static int[][] matrix;
	static boolean[][] visited;
	static int N, result, MAX, cnt;
	static StringTokenizer token;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());

		MAX = 0;
		result = 0;
		matrix = new int[N][N];
		

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(token.nextToken());
				if (MAX < matrix[i][j]) {
					MAX = matrix[i][j];
				}
			}
		}

		for (int h = 0; h < MAX; h++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == false && matrix[i][j] > h) {
						cnt += dfs(h, i, j);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

	// depth -> 비의 양
	static int dfs(int depth, int x, int y) {
		visited[x][y] = true;

		// recursive line
		// 각 지점별 4방 탐색
		for (int k = 0; k < 4; k++) {
			int row = dr[k] + x;
			int col = dc[k] + y;
			if (row >= 0 && row < N && col >= 0 && col < N && matrix[row][col] > depth && visited[row][col] == false) {
				dfs(depth, row, col);
			}
		}
		return 1;
	}
}