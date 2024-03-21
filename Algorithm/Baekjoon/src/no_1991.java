/*
 * Author : 문범수
 * Date : 2024-03-21
 * subject : TREE Traversal
 * page : https://www.acmicpc.net/problem/1991
 * main : 3가지 순회에 대해서 실행하기
 * issue : 숫자가 아닌 문자열을 다루는데 어려움
 * name : no_1991.java
 * duration : 30m
 * no : 1991
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no_1991 {
	static class Node {
		char data;
		Node left;
		Node right;

		Node() {
			this.data = '\0';
		};

		Node(char data) {
			this.data = data;
		}
	}

	static int N;
	static Node[] nodes;
	static char parent, first, second;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		nodes = new Node[N + 1];
		String[] str;
		
		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new Node((char)('A' + i - 1));
		}
		
		for(int i = 1; i < N + 1; i++) {
			str = (reader.readLine()).split(" ");
			parent = str[0].charAt(0);
			first = str[1].charAt(0);
			second = str[2].charAt(0);
			
			// 자식 node가 .인지 아닌지 확인
			if(first != '.') {
				nodes[parent - 'A' + 1].left = nodes[first - 'A' + 1];
			}
			if(second != '.') {
				nodes[parent - 'A' + 1].right = nodes[second - 'A' + 1];
			}
		}
		
		preorder(nodes[1]);
		System.out.println();
		
		inorder(nodes[1]);
		System.out.println();
		
		postorder(nodes[1]);
	}
	
	
	static void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	static void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	}
	
	static void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	}
}
