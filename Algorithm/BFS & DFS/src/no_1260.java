/*
 * Author : 문범수
 * Date : 2024-02-20
 * subject : 재귀함수 동작 원리 이해 
 * page : https://www.acmicpc.net/problem/15649
 * main : BFS & DFS
 * issue : 탐색을 1부터 끝 자연수까지로 설정해야한다.
 * name : no_1260.java
 * duration : 30m
 * no : 1260
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_1260 {

	public static int N;
	public static int M;
	public static int V;
	public static int[][] adjMatrix;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(token.nextToken()); // node 수
		M = Integer.parseInt(token.nextToken()); // edge 수
		V = Integer.parseInt(token.nextToken()); // 출발 위치

		visited = new boolean[N + 1]; // 해당 노드 방문 표시
		adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) { // 인접 행렬 입력 (양방향 연결)
			token = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1;
		}
		visited[V] = true;
		dfs(V);
		visited = new boolean[N + 1];
		visited[V] = true;
		System.out.println();
		bfs();
	}

	public static void dfs(int node) {
		System.out.print(node + " ");
		for (int i = 1; i <= N; i++) {
			if (visited[i] == true || adjMatrix[node][i] == 0) {
				continue;
			}
			visited[i] = true;
			dfs(i);
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			for (int i = 1; i <= N; i++) {
				if (visited[i] == true || adjMatrix[node][i] == 0) {
					continue;
				}
				queue.offer(i);
				visited[i] = true;
			}
		}
	}
}
