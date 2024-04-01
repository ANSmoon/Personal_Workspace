/*
 * Author : 문범수
 * Date : 2024-03-28
 * subject : 
 * page : https://www.acmicpc.net/problem/14502
 * main : DFS & BFS & 재귀함수
 * issue : Logic의 순서를 직관적으로 접근할 것[벽세우기 => 바이러스 감염 => 안전지역 탐색]
 * name : no_14502.java
 * duration : m
 * no : 14502
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_14502 {
	static int N, M, result, size;
	static StringTokenizer token;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] matrix;
	static List<int[]> list; // 빈공간 queue

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		result = 0;
		matrix = new int[N][M];
		list = new LinkedList<>();

		// 0 : 빈칸, 1 : 벽, 2 : 바이러스
		// matrix 입력
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(token.nextToken());
				if (matrix[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		// 조합 메소드 수행
		structure(0, 0);

		// 결과 출력
		System.out.println(result);

	}

	// 조합으로 모든 지역 벽 세우기
	// 전형적인 N과 M 문제
	static void structure(int depth, int start) {
		if (depth == 3) {
			bfs();
			return;
		}

		for (int i = start; i < list.size(); i++) {
			int[] empty = list.get(i);
			int x = empty[0];
			int y = empty[1];

			matrix[x][y] = 1;
			structure(depth + 1, i + 1); // 다음 빈칸으로 이동하기 위한 장치
			matrix[x][y] = 0; // 다시 복구
		}
	}

	// 감염시킬 메소드
	static void bfs() {
		int[][] copy = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = matrix[i][j];
				if (copy[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		// 감염 바이러스 좌표를 모두 돌때까지
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];

			for (int k = 0; k < 4; k++) {
				int row = x + dr[k];
				int col = y + dc[k];

				if (row >= 0 && row < N && col >= 0 && col < M && copy[row][col] == 0) {
					copy[row][col] = 2;
					queue.offer(new int[] { row, col });
				}
			}
		}

		int safe = check(copy);
		result = Math.max(safe, result);

	}

	// 안전지역 확인 메소드
	static int check(int[][] copy) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
}
