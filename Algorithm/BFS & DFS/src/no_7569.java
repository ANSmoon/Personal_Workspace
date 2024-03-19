/*
 * Author : 문범수
 * Date : 2024-03-19
 * subject : 
 * page : https://www.acmicpc.net/problem/7569
 * main : DFS
 * issue : 모든 층을 갖다고 생각하는 능지 이슈 
 * name : no_7569.java
 * duration : 40m
 * no : 7569
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_7569 {
	static StringTokenizer token;
	static int N, M, H, result, total, empty; // N = row, M = col, total = 익은 토마토 갯수, empty = 빈공간
	static int[][][] matrix; // location 은 익은 토마토의 위치
	static Queue<int[]> queue;
	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 }; // 높이 탐색 영역 추가

	public static void main(String[] args) throws Exception {
		// 입력을 받기전 모든 초기화를 진행한다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		token = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(token.nextToken()); // 열
		N = Integer.parseInt(token.nextToken()); // 행
		H = Integer.parseInt(token.nextToken()); // 높이
		result = 0; // 경과 일수
		total = 0; // 익은 토마토 갯수
		matrix = new int[H][N][M];
		queue = new LinkedList<>(); // 익은 토마토의 위치를 저장할 list

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < M; j++) {

					matrix[h][i][j] = Integer.parseInt(token.nextToken());

					// 1인 지역은 모두 방문처리를 한다.
					if (matrix[h][i][j] == 1) {
						queue.offer(new int[] { h, i, j, 0 });
						total++;
					} else if (matrix[h][i][j] == -1) {
						empty++;
					}
				}
			}
		}

		// 이미 꽉차있는 경우 미리 탐색
		if (N * M * H - empty == total) {
			System.out.println(result);
			return;
		}

		bfs();

		if (N * M * H - empty == total) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs() {
		int[] pos;
		int i, j, h, row, col, high;
		while (!queue.isEmpty()) {
			pos = queue.poll();
			h = pos[0];
			i = pos[1];
			j = pos[2];
			result = pos[3];

			// 6방 탐색으로 1이 아닌 0인 지역만 변화시킨다.
			for (int k = 0; k < 6; k++) {
				high = h + dh[k];
				row = i + dr[k];
				col = j + dc[k];
				if (row >= 0 && row < N && col >= 0 && col < M && high >= 0 && high < H
						&& matrix[high][row][col] == 0) {
					matrix[high][row][col] = 1;
					total++;
					queue.offer(new int[] { high, row, col, result + 1 });
				}
			}
		}
	}
}