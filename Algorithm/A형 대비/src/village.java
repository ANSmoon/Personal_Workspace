/*
 * Author : 문범수
 * Date : 2024-04-10
 * subject : Graph 이론
 * page : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
 * main : Graph내 자식 및 부모관계를 2개이상 설정
 * issue : 
 * name : village.java
 * duration : 60m
 * CodeNo : 7465
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int data;
	List<Node> neighbors;
	boolean visited;
	
	public Node (int data){
		this.data = data;
		this.neighbors = new ArrayList<>(); // list 초기화
		this.visited = false; // 방문 지역 초기화
	}
	
	public void addNeighbor(Node neighbor){
		neighbors.add(neighbor); // 이웃 추가
	}
}

public class village {
	static int N, M, result; // N : 총 사람 수 / M : 서로 알고 있는 관계 수 / result : 무리갯수
	static StringTokenizer token;
	

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// Iterator 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			result = 0;
			
			// tree 초기 구성
			Node[] nodes = new Node[N + 1];
			for(int i = 1; i <= N; i++) {
				nodes[i] = new Node(i);
			}
			
			for(int i = 0; i < M; i++) {
				token = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(token.nextToken());
				int v = Integer.parseInt(token.nextToken());
				
				nodes[u].addNeighbor(nodes[v]);
				nodes[v].addNeighbor(nodes[u]);
			}
			
			for(int i = 1; i <= N; i++) {
				if(!nodes[i].visited) {
					dfs(nodes[i]);
					result++;
				}
			}
			System.out.println("#" + index + " " + result);
		}
		
	}
	static void dfs(Node nodes) {
		nodes.visited = true;
		for(Node neighbor : nodes.neighbors) {
			if(!neighbor.visited) {
				dfs(neighbor);
			}
		}
	}
}
