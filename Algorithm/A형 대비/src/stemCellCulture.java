/*
 * Author : 문범수
 * Date : 2024-04-08
 * subject : 완전탐색
 * page : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo&
 * main : BFS + 구현
 * issue : 생명력 기간동안 살아있다는 정보를 놓침
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
	static int N, M, K, result, rowSize, colSize; // N행 M열 K시간, 결과
	static int[][] matrix; // 전체 field
	static int[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static StringTokenizer token;
	static Queue<int[]> queue; // x, y, 생명력, 활성화까지 남은 시간
	static Queue<int[]> remain;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			rowSize = N + (2 * K);
			colSize = M + (2 * K);
			// N행 M열의 행렬이 K시간동안 최대로 퍼질수 있는 크기는 중앙에서 2K씩 늘어난 경우
			matrix = new int[rowSize][colSize];
			visited = new int[rowSize][colSize];
			queue = new LinkedList<>();
			remain = new LinkedList<>();

			// 중앙에 배치하도록 설정
			for (int i = K; i < K + N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = K; j < K + M; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					if (matrix[i][j] > 0) {
						visited[i][j] = 500; // 맨 처음 위치는 500으로 설정
						// x좌표, y좌표, 생명력, 활성화까지 남은 시간
						queue.offer(new int[] { i, j, matrix[i][j], matrix[i][j] });
						remain.offer(new int[] { i, j, matrix[i][j]});
					}
				}
			}
			bfs();
			System.out.println("#" + index + " " + result);
		}
	}

	static void bfs() {
		for (int i = 0; i < K; i++) {
			int cycle = queue.size(); // K시간동안 Queue에 현재 들어있는 만큼만 돌것
			for (int j = 0; j < cycle; j++) {
				int[] pos = queue.poll();
				int row = pos[0]; // 미생물 위치
				int col = pos[1];
				int totalLife = pos[2]; // 미생물 생명력 수치 / 생명력 수치 시간동안 살아있음!
				int remainLife = pos[3]; // 미생물 활성화까지 남은 시간

				if (remainLife == 0) { // 활성화 시간까지 도달했다면
					for (int k = 0; k < 4; k++) {
						int n_row = row + dr[k];
						int n_col = col + dc[k];
						// 같은 depth인지 구분할 필요가 있음.(같은 시간에 도달한 경우를 구현)
						if (n_row >= 0 && n_col >= 0 && n_row < rowSize && n_col < colSize) {
							// 방문을 안했거나 같은 시간대에 방문처리가 된경우
							// 비교를 통해 더 생명력이 큰 녀석이 자리 차지
							// visited => 현재 경과 시간 입력
							if (visited[n_row][n_col] == 0 || visited[n_row][n_col] == i) {
								if (totalLife > matrix[n_row][n_col]) {
									matrix[n_row][n_col] = totalLife;
									visited[n_row][n_col] = i;
								}
							}
						}
					}
				} else { // 활성시간에 도달하지 않았을 경우
					queue.offer(new int[] { row, col, totalLife, remainLife - 1 });
				}
			}
			// 해당 시간대에 채워진 녀석들을 다시 넣어준다.(순서 상관 X)
			for (int l = 0; l < rowSize; l++) {
				for (int m = 0; m < colSize; m++) {
					if (visited[l][m] == i) {
						queue.offer(new int[] { l, m, matrix[l][m], matrix[l][m] });
					}
				}
			}
		}
		result = queue.size();
	}
}