/*
 * Author : 문범수
 * Date : 2024-04-02
 * subject : BFS
 * main : 완전탐색
 * issue : 소용돌이를 만났을 때 대응 logic 오류
 * name : swimmingContest.java
 * duration : 210m
 * CodeNo : 4193
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swimmingContest {
	static int N, result; // N, 결과값 변수
	static int[][] matrix; // 행렬
	static int[] start, finish; // 출발 및 도착지 x, y좌표
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static StringTokenizer token;
	static boolean[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			queue = new LinkedList<>();
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(reader.readLine());
			visited = new boolean[N][N];
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			// 출발지점
			int x, y;
			token = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(token.nextToken());
			y = Integer.parseInt(token.nextToken());
			start = new int[] { x, y, 0};
			visited[x][y] = true;
			queue.offer(start);

			// 도착지점
			int z, t;
			token = new StringTokenizer(reader.readLine());
			z = Integer.parseInt(token.nextToken());
			t = Integer.parseInt(token.nextToken());
			finish = new int[] { z, t };
			
			search();
			
			// 만약 도착지점에 도달하지 못했을 경우
			if(!visited[z][t]) {
				result = -1;
			}

			System.out.println("#" + index + " " + result);
		}
	}

	// BFS 소용돌이 여부에 따른 구현
	static void search() {
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int timer = pos[2];
//			System.out.println("X : " + x + " Y : " + y + " timer : " + timer);
			
			// 도착지점에 도착한 경우
			if (x == finish[0] && y == finish[1]) {
//				System.out.println(Arrays.toString(finish));
//				System.out.print(" result : " + result);
				result = Math.min(timer, result);
			}
			
			// 현재 위치에서 4방 탐색 진행
			for (int k = 0; k < 4; k++) {
				int row = x + dr[k];
				int col = y + dc[k];
				
				// 범위 및 1이 아닌 지역인지 파악
				if (row >= 0 && col >= 0 && row < N && col < N && matrix[row][col] != 1) {
					// 해당 지역이 0인 경우
					if (matrix[row][col] == 0 && !visited[row][col]) {
						visited[row][col] = true;
						queue.offer(new int[] { row, col, timer + 1});
					
						// 장애물이 있는 경우
					} else if (matrix[row][col] == 2 && !visited[row][col]) {
						if(timer % 3 == 2) { // 현재 시간 기준 3으로 나눠 1이 남는다면 소용돌이가 사라지는 시간이므로 진행 가능
							queue.offer(new int[] { row, col, timer + 1});
							visited[row][col] = true;
						}else { // 그 외에 경우에는 큐에 시간을 늘려서 다시 삽입한다. 대신 소용돌이의 위치가 아닌 현재 위치를 넣어줘야 한다.
							queue.offer(new int[] { x, y, timer + 1});
						}
						
					}
				}
			}
		}
	}
}