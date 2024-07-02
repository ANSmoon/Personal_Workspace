/*
 * Author : 문범수
 * Date : 2024-02-14
 * subject : DFS 적용
 * page : https://www.acmicpc.net/problem/15649
 * main : BackTracking
 * issue : 재귀 함수 순서 이해
 * name : N과M_1.java
 * duration : 60m
 * no : 15649
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_1 {
	// 필요 변수 선언
	public static boolean[] visit; // 해당 node 방문여부 판단 배열
	public static int[] arr; // 조건에 해당하는 배열 저장 부분

	public static void main(String[] args) throws Exception {
		// N까지 숫자중 M개씩 중복없이 고른 수열

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		// N M 입력
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		visit = new boolean[N];
		arr = new int[M];
		// 깊이는 0부터 시작
		dfs(N, M, 0);
	}

	public static void dfs(int N, int M, int depth) {
		// 재귀 깊이가 M과 같다면 배열 출력
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) { // 배열 내 모든 인자들 출력
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 방문하지 않았다면 진입
			if (visit[i] == false) {
				visit[i] = true; // 먼저 방문 체크
				arr[depth] = i + 1; // 순열 저장[1부터]
				dfs(N, M, depth + 1); // dfs 깊이 증가
				
				// 자식 node 방문이 끝나고 돌아오면 다시 node 방문하지 않은 것으로 처리
				// 방금 출력을 마치고 돌아왔기 때문에 출력 뒤에는 방문하지 않은 것으로 처리
				visit[i] = false;
			}
		}
		return;
	}
}
