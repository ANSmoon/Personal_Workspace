/*
 * Author : 문범수
 * Date : 2024-04-08
 * subject : 
 * main : 
 * issue : 
 * name : stemCellCulture.java
 * duration : 60m
 * CodeNo : 5653
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class stemCellCulture {
	static int N, M, K, result; // N행 M열 K시간, 결과
	static int[][] matrix; // 전체 field
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static StringTokenizer token;
	static Queue<int[]> queue; // x, y, 생존 시간, 활성화까지 남은 시간

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			// N행 M열의 행렬이 K시간동안 최대로 퍼질수 있는 크기는 중앙에서 2K씩 늘어난 경우
			matrix = new int[N + (2 * K)][M + (2 * K)];
			visited = new boolean[N + (2 * K)][M + (2 * K)];
			queue = new LinkedList<>();

			// 중앙에 배치하도록 설정
			for (int i = K; i < K + N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = K; j < K + M; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					visited[i][j] = true;
					queue.offer(new int[] { i, j, matrix[i][j], matrix[i][j] });
				}
			}

			bfs();

			System.out.println("#" + index + " " + result);
		}
	}

	static void bfs() {
		for (int i = 0; i < K; i++) {
			int size = queue.size(); // K시간동안 Queue에 현재 들어있는 만큼만 돌것
			for (int j = 0; j < size; j++) {
				int[] pos = queue.poll();
				int row = pos[0]; // 미생물 위치
				int col = pos[1];
				int totalLife = pos[2]; // 미생물 생명력 수치
				int remainLife = pos[3]; // 미생물 활성화까지 남은 시간

				if (remainLife == 0) { // 활성화 시간까지 도달했다면
					for (int k = 0; k < 4; k++) {
						int n_row = row + dr[k];
						int n_col = col + dc[k];
						// 같은 depth인지 구분할 필요가 있음.
						if(n_row >= 0 && n_col >= 0 && n_row < N && n_col < M && !visited[n_row][n_col]) {
							
						}
					}

				} else {
					queue.offer(new int[] { row, col, totalLife, remainLife--});
				}

			}

		}

	}
}