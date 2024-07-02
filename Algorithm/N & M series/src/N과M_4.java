/*
 * Author : 문범수
 * Date : 2024-02-27
 * subject : DFS
 * page : https://www.acmicpc.net/problem/15649
 * main : Back Tracking
 * issue : 시간초과
 * name : N과M_3.java
 * duration : 20m
 * no : 15651
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4 {
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[M];

		dfs(0, 1);
		System.out.println(sb);
	}

	public static void dfs(int depth, int start) {
		// base case
		if (depth >= M) {
			for (int i = 0; i < depth; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		// recursive case
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1, i);
		}
		return;
	}
}