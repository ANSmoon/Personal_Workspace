/*
 * Author : 문범수
 * Date : 2024-03-12
 * subject :
 * page : https://www.acmicpc.net/problem/4963
 * main : DFS
 * issue : N과 M 바꿔서 사용
 * name : no_4963.java
 * duration : 20m
 * no : 4963
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no_4963 {
	static int N, M, result;
	static int[][] matrix;
	static boolean[][] visited;
	static StringTokenizer token;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 행 탐색
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 열 탐색
	
	
	public static void main(String[] args) throws Exception {
		while(true) {
			token = new StringTokenizer(reader.readLine());
			M = Integer.parseInt(token.nextToken());
			N = Integer.parseInt(token.nextToken());
			result = 0;
			visited = new boolean[N][M];
			matrix = new int[N][M];
			
			// 마지막 줄 0과 0을 입력받을 시 break;
			if(N == 0 && M == 0) {
				break;
			}
			
			// matrix에 현재 위치 입력
			for(int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for(int j = 0; j < M; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}	
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && matrix[i][j] != 0) {
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	// dfs의 역할은 섬에 해당하는 지역을 방문하는 역할 뿐, 반환 값 없음
	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int k = 0; k < 8; k++) {
			int row = i + dr[k];
			int col = j + dc[k];
			if(row >= 0 && row < N && col >= 0 && col < M && !visited[row][col] && matrix[row][col] != 0) {
				dfs(row, col);
			}
		}
		
	}
}