/*
 * Author : 문범수
 * Date : 2024-04-01
 * subject : Stack
 * main : Topological sort 구현
 * issue : 
 * name : orderOfWork_Stack.java
 * duration : 10m
 * CodeNo : 1267
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class orderOfWord_Stack {
	static int V, E;
	static int[][] matrix;
	static int[] inDegree;
	static StringBuilder sb;
	static Stack<Integer> stack;
	static boolean[] visited;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int index = 1; index <= 10; index++) {
			token = new StringTokenizer(reader.readLine());
			
			V = Integer.parseInt(token.nextToken());
			E = Integer.parseInt(token.nextToken());
			sb = new StringBuilder();

			matrix = new int[V + 1][V + 1]; // vertex 1부터 시작
			inDegree = new int[V + 1]; // in_degree 저장 배열
			stack = new Stack<>();
			visited = new boolean[V + 1];

			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < E; i++) {
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				// 행렬 저장
				matrix[x][y] = 1;
				inDegree[y]++; // in_degree 추가
			}

			for (int i = 1; i < V + 1; i++) {
				if (inDegree[i] == 0) {
					dfs(i);
				}
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
			}

			System.out.println("#" + index + " " + sb);
		}

	}

	static void dfs(int v) {
		visited[v] = true;

		// recursive line
		for (int i = 1; i < V + 1; i++) {
			if (!visited[i] && matrix[v][i] == 1) {
				dfs(i);
			}
		}

		// base line
		stack.add(v);
	}
}
