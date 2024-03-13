/*
 * Author : 문범수
 * Date : 2024-03-13
 * subject : 
 * page : https://www.acmicpc.net/problem/7576
 * main : DFS
 * issue : DFS와 Queue를 사용하는 혼종
 * name : no_7576.java
 * duration : m
 * no : 7576
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_7576 {
	static StringTokenizer token;
	static int N, M, result, total, empty; // N = row, M = col, total = 익은 토마토 갯수, empty = 빈공간
	static int[][] matrix; // location 은 익은 토마토의 위치
	static boolean[][] visited;
	static Queue<Integer> queue;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// 입력을 받기전 모든 초기화를 진행한다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		token = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		result = 0;
		total = 0;
		matrix = new int[N][M];
		queue = new LinkedList<>(); // 익은 토마토의 위치를 저장할 list
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(token.nextToken());

				// 1인 지역은 모두 방문처리를 한다.
				if (matrix[i][j] == 1) {
					visited[i][j] = true;
					queue.offer(i); // list에 row와 col을 순차적으로 담는다.
					queue.offer(j);
					total++;
				} else if (matrix[i][j] == -1) {
					empty++;
				}
			}
		}
		
		// 이미 꽉차있는 경우 미리 탐색
		if (N * M - empty == total) {
			System.out.println(result + " " + total);
			return;
		} 

		// 현재 익은 토마토 기준 순회
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size / 2; i++) {
				dfs(queue.poll(), queue.poll(), 0);
			}
			result++;
		}

		if (N * M - empty == total) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

	public static void dfs(int i, int j, int depth) {
		if (depth == 2) {
			return;
		}
		visited[i][j] = true;
		if(matrix[i][j] != 1) {
			total++;
		}
		matrix[i][j] = 1;

		// 4방 탐색으로 1이 아닌 0인 지역만 변화시킨다.
		for (int k = 0; k < 4; k++) {
			int row = i + dr[k];
			int col = j + dc[k];
			if (row >= 0 && row < N && col >= 0 && col < M && !visited[row][col] && matrix[row][col] != -1) {
				queue.offer(row);
				queue.offer(col);
				dfs(row, col, depth + 1);
			}
		}
	}
}