/*
 * Author : 문범수
 * Date : 2024-03-10
 * subject : Back Tracking
 * page : https://www.acmicpc.net/problem/2667
 * main : DFS
 * issue : DFS를 실행하는 조건 실수
 * name : no_2667.java
 * duration : 40m
 * no : 2667
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no_2667 {
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, cnt, index;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());

		// visited & matrix 입력
		visited = new boolean[N][N];
		matrix = new int[N][N];
		index = 0;
		List<Integer> list = new ArrayList<>();
		// 단지 갯수를 담을 result 배열 생성
		

		for (int i = 0; i < N; i++) {
			String str = reader.readLine();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = str.charAt(j) - '0';
			}
		}

		// 각 지점을 돌면서 단지 갯수 파악
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (!visited[i][j] && matrix[i][j] == 1) {
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		// 총 단지수 = index
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}

	static void dfs(int x, int y) {
		// base line
		visited[x][y] = true;
		cnt++;

		// recursive line
		for (int k = 0; k < 4; k++) {
			int row = x + dr[k];
			int col = y + dc[k];
			if (row >= 0 && row < N && col >= 0 && col < N && !visited[row][col] && matrix[row][col] == 1) {
				dfs(row, col);
			}
		}
		return;
	}
}