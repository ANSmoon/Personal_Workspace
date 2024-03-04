/*
 * Author : 문범수
 * Date : 2024-02-14
 * subject : Tree[Lowest Common Ancestor]
 * main : 최소 공통 조상 탐색 알고리즘
 * issue : 재귀 함수 호출 이슈
 * name : commonAncestor.java
 * duration : 250m
 * CodeNo : 1248 
 * 
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// node class 생성
class Node {
	int data;
	int parent;
	Node left;
	Node right;

	Node() {
	};

	Node(int data) {
		this.data = data;
	}
}

public class commonAncestor {
	static Node[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 전체 테스트 케이스 total
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		// 반복문 시작
		while (index <= total) {
			// 정점 갯수 V / 간선 갯수 E / 두 정점 x, y
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int V = Integer.parseInt(token.nextToken());
			int E = Integer.parseInt(token.nextToken()); // 미사용
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			int parent; // 부모 노드 변수
			
			// 간선 정보 입력
			token = new StringTokenizer(reader.readLine());

			// node 생성
			// index 1부터 시작
			nodes = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				nodes[i] = new Node(i);
			}

			while (token.hasMoreTokens()) {
				// 부모 node
				parent = Integer.parseInt(token.nextToken());
				// 자식 node
				int child = Integer.parseInt(token.nextToken());

				// tree 구현 => 자식 노드를 순차적으로 왼쪽 오른쪽에 담는다.
				// 만약 부모 node가 바뀌면 바뀐 부모 node의 왼쪽 오른쪽 자식 node에 담는다.
				if (nodes[parent].left == null) {
					nodes[parent].left = nodes[child];
				} else {
					nodes[parent].right = nodes[child];
				}
				nodes[child].parent = parent;
			}
			visited = new boolean[V + 1];
			System.out.println("#" + index + " " + search(x, y) + " " + size(nodes[search(x, y)]));
			index++;
		}
	}

// 공통 조상 탐색 method
// x, y를 탐색할 수 있으면 해당 node 값 반환
	static int search(int x, int y) {
		// x의 부모 노드를 탐색하며 y가 나오면 공통 조상으로 판단하여 반환
		while (x != 0) {
			x = nodes[x].parent;
			visited[x] = true;
		}
		// y의 부모 노드를 탐색하며 x가 나오면 공통 조상으로 판단하여 반환
		while (y != 0) {
			y = nodes[y].parent;
			if (visited[y]) {
				return y;
			}
		}
		return 0;
	}

// 해당 정점에 연결된 모든 정점의 갯수
	static int size(Node node) {
		if (node == null) {
			return 0;
		}
		return size(node.left) + size(node.right) + 1;
	}
}