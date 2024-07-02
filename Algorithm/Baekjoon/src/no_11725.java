/*
 * Author : 문범수
 * Date : 2024-03-20
 * subject : 자식을 left, right가 아닌 list로 입력 받는다.
 * page : https://www.acmicpc.net/problem/11725
 * main : Tree 순회
 * issue : 이진 트리라고 명시가 되어 있지 않기 때문에 이진 트리로 풀면 안된다.
 *  root가 있는 tree 형태가 아니기 때문에 위에서 아래 형식으로 연결하면 안된다.
 * name : no_11725.java
 * duration : 60m
 * no : 11725
 */

// Node class 선언
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_11725 {
	static int N, first, second, current;
	static int[] parent;
	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		nodes = new ArrayList[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];

		// 각 노드의 연결 정보 저장
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			first = Integer.parseInt(token.nextToken());
			second = Integer.parseInt(token.nextToken());
			nodes[first].add(second);
			nodes[second].add(first);
		}

		// BFS로 부모 노드 탐색
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 1을 root로 지정했기 때문에 1을 넣어준다.

		// queue에 요소가 있을동안 탐색
		// BFS
		while (!queue.isEmpty()) {
			current = queue.poll(); // 현재 위치
			visited[current] = true;

			for (int child : nodes[current]) {
				if (!visited[child]) {
					parent[child] = current;
					queue.offer(child);
				}
			}
		}

		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}
	}
}