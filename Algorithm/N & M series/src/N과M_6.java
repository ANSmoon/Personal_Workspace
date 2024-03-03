/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 임의의 숫자에 대한 특정 갯수 만큼의 오름차순 출력[중복제외]
 * page : https://www.acmicpc.net/problem/15655
 * main : BackTracking
 * issue : 
 * name : N과M_6.java
 * duration : m
 * no : 15655
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_6 {
	static int N, M;
	static int[] arr;
	static int[] tmp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		tmp = new int[N];

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}

	private static void dfs(int depth, int start) {
		// base line
		if (depth >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		// recursive line
		for (int i = start; i < N; i++) {
			tmp[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
		return;
	}
}