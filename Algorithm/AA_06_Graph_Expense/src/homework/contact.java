/*
 * Author : 문범수
 * Date : 2024-03-28
 * subject : 
 * main : 
 * issue : 
 * name : contact.java
 * duration : m
 * CodeNo : 1238
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class contact {
	static class Node {
		int v;

		public Node(int v) {
			this.v = v;
		}
	}

	static StringTokenizer token;
	static int N, start, result, max;
	static List<Node>[] list;
	static int[] arr;
	static int[] visited;
	static List<Integer> ans;
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int index = 1; index <= 10; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			start = Integer.parseInt(token.nextToken());
			result = 0;
			list = new ArrayList[101]; // 연락처 1 ~ 100
			visited = new int[101];
			queue = new LinkedList<>();
			ans = new ArrayList<>();

			token = new StringTokenizer(reader.readLine());

			for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<Node>();
			}

			// linked list 형태의 연결로 저장
			while (token.hasMoreTokens()) {
				list[Integer.parseInt(token.nextToken())].add(new Node(Integer.parseInt(token.nextToken())));
			}
			
//			visited[start] = 1;
			for(int i = 0; i < list[start].size(); i++) {
				queue.offer(new int[] {start, 1});
			}
			max = 0;
			
			bfs();
			
			// 가장 깊이가 깊었던 index 탐색
			for(int i = 1; i < visited.length; i++) {
				if(max <= visited[i]) {
					max = visited[i];
					ans.add(i);
				}
			}
			
			Collections.sort(ans, Collections.reverseOrder());
			result = ans.get(0);
			System.out.println("#" + index + " " + result);
		}
	}

	static void bfs() {
		int[] arr;
		while (!queue.isEmpty()) {
			arr = queue.poll();
			int x = arr[0];
			int depth = arr[1];
			
			for (int i = 0; i < list[x].size(); i++) {
				if(visited[list[x].get(i).v] == 0) {
					visited[list[x].get(i).v] = depth + 1;
					queue.offer(new int[] {list[x].get(i).v, depth + 1});
				}
			}
		}
	}
}