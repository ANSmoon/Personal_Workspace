/*
 * Author : 문범수
 * Date : 2024-02-19
 * subject : dfs
 * page : https://www.acmicpc.net/problem/15650
 * main : back tracking
 * issue : start 지점을 어떻게 변경 시킬 수 있는지가 관건
 * name : N과M_2.java
 * duration : 120m
 * no : 15649
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2 {
	public static int[] arr;
	public static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(token.nextToken()); // 자연수 갯수
		M = Integer.parseInt(token.nextToken()); // 고를 수 있는 갯수

		arr = new int[M];
		dfs(1, 0);
	}

	public static void dfs(int start, int depth) {
		// base case
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		// recursive case
		// 1부터 시작
		for(int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
		
		return;
	}
}