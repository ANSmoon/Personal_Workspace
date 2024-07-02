/*
 * Author : 문범수
 * Date : 2024-03-27
 * subject : 
 * page : https://www.acmicpc.net/problem/2206
 * main : BFS
 * issue : 벽을 부순 경우와 안 부순 경우를 나눠서 탐색해야함
 * 이유 => 벽을 부순 경로와 벽을 부수지 않았을 때 경로가 겹치기 때문에
 * 이미 벽을 부쉈다면 경로를 돌아서 가게 될 텐데 그러면서 해당 경로로 벽을 뚫고 지나가려면
 * 방문처리가 안되어있어야 하므로 둘의 방문처리를 구분해야 함.
 * name : no_2206.java
 * duration : 13m
 * no : 2206
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_2206 {
	static int N, M, hammer, result, min; // 목적지는 (N-1, M-1) 위치, start = (0, 0)
	static int[][] matrix; // hammer = 벽을 부순 횟수(1회까지 가능)
	static boolean[][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		String tmp;
		result = 0;
		min = Integer.MAX_VALUE;
		queue = new LinkedList<>();
		matrix = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			tmp = reader.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = tmp.charAt(j) - '0';
			}
		}

		// 시작위치와 도착위치도 방문횟수 포함
		// 벽을 한번까지 부술 수 있음

		bfs();
		if (!visited[N - 1][M - 1][0] && !visited[N-1][M-1][1]) {
			min = -1;
		}
		System.out.println(min);

	}

	static void bfs() {
		int[] pos;
		// queue 에 (0,0) 좌표 및 깬 블록의 갯수 넘겨준다.
		queue.offer(new int[] { 0, 0, 0, 1 });
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int cnt = pos[2];
			int result = pos[3];

			if (x == N - 1 && y == M - 1) {
				min = Math.min(result, min);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int row = x + dr[k];
				int col = y + dc[k];

				if (row >= 0 && row < N && col >= 0 && col < M) {
					if (matrix[row][col] == 1) { // 벽이 있는 경우
						if (!visited[row][col][1] && cnt == 0) {
							visited[row][col][1] = true;
							queue.offer(new int[] { row, col, 1, result + 1 });
						}
					} else { // 벽이 없는 경우
						if (!visited[row][col][cnt]) {
							visited[row][col][cnt] = true;
							queue.offer(new int[] { row, col, cnt, result + 1 });
						}
					}
				}
			}
		}
	}
}
