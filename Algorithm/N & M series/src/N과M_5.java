/*
 * Author : 문범수
 * Date : 2024-03-02
 * subject : 임의의 숫자에 대한 특정 갯수 만큼의 오름차순 출력
 * page : https://www.acmicpc.net/problem/15654
 * main : BackTracking
 * issue : 
 * name : N과M_5.java
 * duration : m
 * no : 15654
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {
	static int N, M;
	static int[] arr;
	static int[] tmp;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		tmp = new int[N];
		visited = new boolean[N];
		
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		// base line
		if (depth >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		// recursive line
		for (int i = 0; i < N; i++) {
			if (visited[i] != true) {
				tmp[depth] = arr[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
		return;
	}
}