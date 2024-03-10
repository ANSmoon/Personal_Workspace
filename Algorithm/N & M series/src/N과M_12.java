/*
 * Author : 문범수
 * Date : 2024-03-04
 * subject : 
 * page : https://www.acmicpc.net/problem/15666
 * main : DFS
 * issue : 시작위치 애매
 * name : N과M_12.java
 * duration : 15m
 * no : 15666
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_12 {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
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
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start) {
		// base line
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		int before = -1; // 핵심 부분
		
		// recursive line
		for (int i = start; i < N; i++) {
			if (before != arr[i]) {
				result[depth] = arr[i];
				before = arr[i];
				dfs(depth + 1, i);
			}
		}
	}
}
