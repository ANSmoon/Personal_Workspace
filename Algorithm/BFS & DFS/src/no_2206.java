/*
 * Author : 문범수
 * Date : 2024-03-20
 * subject : 
 * page : https://www.acmicpc.net/problem/2206
 * main : BFS
 * issue : 
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
	static int N, M, hammer, result; // 목적지는 (N-1, M-1) 위치, start = (0, 0)
	static int[][] matrix; // hammer = 벽을 부순 횟수(1회까지 가능)
	static boolean[][] visited;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		String tmp;
		result = 0;

		matrix = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tmp = reader.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		// 시작위치와 도착위치도 방문횟수 포함
		// 벽을 한번까지 부술 수 있음

	}

}
