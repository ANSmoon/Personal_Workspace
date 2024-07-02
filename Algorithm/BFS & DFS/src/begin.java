/*
 * Author : 문범수
 * Date : 2024-02-0
 * subject : DFS & BFS 구현
 * page : https://www.acmicpc.net/problem/1260
 * main : 
 * issue : 
 * name : begin.java
 * duration : m
 * no : 1260
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class begin {
// 필요 변수 선언
	public static int N, M, V;
	public static int[][] adjMatrix;
	public static int[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 1부터 사용하기 때문에 +1 필요
		adjMatrix = new int[N + 1][N + 1]; // 간선 정보 저장
		visited = new int[N + 1];		   // 방문 정보 저장

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 연결된 간선 표시
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}

		// 출발 지점 방문 표시
		visited[V] = 1;
		
		// 해당 지점에서 dfs 시작
		DFS(V);
		
		System.out.println();
		
		// 방문지점 초기화
		visited = new int[N + 1];
		
		// 출발 지점 방문 표시
		visited[V] = 1;
		
		// BFS 시작
		BFS();

	}

	public static void DFS(int node) {
		System.out.print(node + " ");

		for (int next = 1; next <= N; next++) {
			// 해당 node를 방문했거나, 해당 node까지의 간선이 존재하지 않는 경우 다음 node로 이동
			if (visited[next] == 1 || adjMatrix[node][next] == 0) {
				continue;
			}
			
			// 위 조건에 속하지 않는 경우 방문 표시
			visited[next] = 1;
			
			// 다음 node에 대해 재귀 호출
			DFS(next);
		}
	}

	public static void BFS() {
		// Queue로 구현
		Queue<Integer> q = new LinkedList<>();
		
		// queue에 node 삽입
		q.offer(V);
		
		// queue를 다 탐색할 때까지
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for (int next = 1; next <= N; next++) {
				// 마찬가지 조건 구현
				if (visited[next] == 1 || adjMatrix[node][next] == 0) {
					continue;
				}
				visited[next] = 1;
				// 순차적 탐색
				q.offer(next);
			}
		}
	}
}