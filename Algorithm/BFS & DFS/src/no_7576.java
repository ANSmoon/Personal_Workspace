/*
 * Author : 문범수
 * Date : 2024-03-13
 * subject : 조건에 맞는 순차 탐색
 * page : https://www.acmicpc.net/problem/7576
 * main : DFS
 * issue : DFS와 Queue를 사용하는 혼종 / depth가 1이어야 4방탐색에서 그 위치를 queue에 넣고 종료된다. / BFS를 DFS로 품
 * => 미친 풀이
 * name : no_7576.java
 * duration : 90m
 * no : 7576
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_7576 {
	static StringTokenizer token;
	static int N, M, result, total, empty; // N = row, M = col, total = 익은 토마토 갯수, empty = 빈공간
	static int[][] matrix; // location 은 익은 토마토의 위치
	static Queue<int[]> queue;
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

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(token.nextToken());

				// 1인 지역은 모두 방문처리를 한다.
				if (matrix[i][j] == 1) {
					queue.offer(new int[] { i, j, 0 });
					total++;
				} else if (matrix[i][j] == -1) {
					empty++;
				}
			}
		}

		// 이미 꽉차있는 경우 미리 탐색
		if (N * M - empty == total) {
			System.out.println(result);
			return;
		}

		bfs();

		if (N * M - empty == total) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs() {
		int[] pos;
		int i, j, row, col;
		while (!queue.isEmpty()) {
			pos = queue.poll();
			i = pos[0];
			j = pos[1];
			result = pos[2];

			// 4방 탐색으로 1이 아닌 0인 지역만 변화시킨다.
			for (int k = 0; k < 4; k++) {
				row = i + dr[k];
				col = j + dc[k];
				if (row >= 0 && row < N && col >= 0 && col < M && matrix[row][col] == 0) {
					matrix[row][col] = 1;
					total++;
					queue.offer(new int[] {row, col, result + 1});
				}
			}
		}
	}
}