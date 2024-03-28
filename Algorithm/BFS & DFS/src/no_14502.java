/*
 * Author : 문범수
 * Date : 2024-03-28
 * subject :
 * page : https://www.acmicpc.net/problem/14502
 * main : 
 * issue : 
 * name : no_14502.java
 * duration : m
 * no : 14502
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_14502 {
	static int N, M, result, cnt, size;
	static StringTokenizer token;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> queue;
	static boolean[] visited;
//	static boolean[][] visited1;
	static boolean[][] visited2;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		queue = new LinkedList<>();
		int[][] matrix = new int[N][M];
		boolean[][] visited1 = new boolean[N][M]; // 감염용 visited
		visited2 = new boolean[N][M]; // 안전용 visited
		list = new ArrayList<>();
		result = 0;
		cnt = 0;

		// 0 : 빈칸, 1 : 벽, 2 : 바이러스
		// matrix 입력
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(token.nextToken());
				if (matrix[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
				if (matrix[i][j] == 1) {
					visited1[i][j] = true;
					visited2[i][j] = true;
				}
				if (matrix[i][j] == 0) {
					list.add(new int[] { i, j });
				}

			}
		}

		size = list.size();
		visited = new boolean[size];

		// 조합 메소드 수행
		structure(0, matrix, visited1);

		// 결과 출력
		System.out.println(result);

	}

	// 조합으로 모든 지역 벽 세우기
	static void structure(int depth, int[][] matrix, boolean[][] visited1) {
		// base line
		if (depth == 3) { // 벽 3개 다 세웠으면 감염시키고 안전지역 확인
			int[][] tmp = bfs(matrix, visited1);
			visited2 = new boolean[N][M];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] == 0 && !visited2[i][j]) {
						check(bfs(matrix, visited1), i, j); // 전달받은 행렬 기준으로 감염
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}

		// recursive line
		for (int i = 0; i < size; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				int[] arr = list.get(i);
				int x = arr[0];
				int y = arr[1];
				matrix[x][y] = 1;
				structure(depth + 1, matrix, visited1);
				visited[i] = false;
			}
		}

	}

	// 감염시킬 메소드
	static int[][] bfs(int[][] matrix, boolean[][] visited1) {
		int[] pos = queue.poll();

		while (!queue.isEmpty()) {
			int x = pos[0];
			int y = pos[1];

			for (int k = 0; k < 4; k++) {
				int row = x + dr[k];
				int col = y + dc[k];

				if (row >= 0 && row < N && col >= 0 && col < M && !visited1[row][col] && matrix[row][col] != 1) {
					visited1[row][col] = true;
					matrix[row][col] = 2;
				}
			}
		}
		return matrix;
	}

	// 안전지역 확인 메소드
	static void check(int[][] matrix, int x, int y) {
		visited2[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int row = x + dr[k];
			int col = y + dc[k];
			if (row >= 0 && col >= 0 && row < N && col < M && !visited2[row][col]) {
				visited2[row][col] = true;
				check(matrix, row, col);
			}
		}
	}
}
