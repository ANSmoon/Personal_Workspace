/*
 * Author : 문범수
 * Date : 2024-03-20
 * subject : 자식을 left, right가 아닌 list로 입력 받는다.
 * page : https://www.acmicpc.net/problem/11725
 * main : Tree 순회
 * issue : 이진 트리라고 명시가 되어 있지 않기 때문에 이진 트리로 풀면 안된다.
 * name : no_11725.java
 * duration : 60m
 * no : 11725
 */

// Node class 선언

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int parent;
	ArrayList<Node> children;

	Node() {
		this.parent = 0;
		this.children = new ArrayList<>();
	}
}

public class no_11725 {
	static int N, first, second;
	static Node[] nodes;
	static boolean[] haveParent;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		nodes = new Node[N + 1];
		haveParent = new boolean[N+1];
		
		// 각 node의 data 삽입
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node();
		}
		
		haveParent[1] = true;

		for (int i = 1; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			first = Integer.parseInt(token.nextToken());
			second = Integer.parseInt(token.nextToken());
			
			// 첫번째 숫자가 부모가 있을 경우
			if(haveParent[first]) {
				nodes[first].children.add(nodes[second]);
				nodes[second].parent = first;
				haveParent[second] = true;
			}
			// 두번째 숫자가 부모가 있을 경우
			else {
				nodes[second].children.add(nodes[first]);
				nodes[first].parent = second;
				haveParent[first] = true;
			}
		}
		for(int i = 2; i < N + 1; i++) {
			System.out.println(nodes[i].parent);
		}
	}
}
