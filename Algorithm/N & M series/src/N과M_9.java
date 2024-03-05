/*
 * Author : 문범수
 * Date : 2024-03-04
 * subject :
 * page : https://www.acmicpc.net/problem/15663
 * main : 
 * issue : 
 * name : N과M_9.java
 * duration : m
 * no : 15663
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_9 {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		result = new int[M];

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
		visited = new boolean[arr[arr.length - 1] + 1];
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		// base line
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		// recursive line
		for (int i = 0; i < N; i++) {
			if (visited[arr[i]] == false) {
				visited[arr[i]] = true;
				result[depth] = arr[i];
				dfs(depth + 1);
				visited[arr[i]] = false;
			}
		}
	}
}
