/*
 * Author : 문범수
 * Date : 2024-04-01
 * subject : BFS
 * main : Topological sort 구현
 * issue : Queue 초기화 위치 실수
 * name : orderOfWork_Queue.java
 * duration : 30m
 * CodeNo : 1267
 */

package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class orderOfWork_Queue {
	static int V, E;
	static Queue<Integer> queue;
	static int[][] matrix;
	static int[] inDegree;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int index = 1; index <= 10; index++) {
			V = sc.nextInt();
			E = sc.nextInt();

			matrix = new int[V + 1][V + 1]; // vertex 1부터 시작
			inDegree = new int[V + 1]; // in_degree 저장 배열
			list = new ArrayList<>();
			queue = new LinkedList<>();
			
			for(int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				// 행렬 저장
				matrix[x][y] = 1;
				inDegree[y]++; // in_degree 추가
			}
			
			// in_degree가 0인 vertex 정리
			for(int i = 1; i < V + 1; i++) {
				if(inDegree[i] == 0) {
					queue.offer(i);
				}
			}
			
			
			while(!queue.isEmpty()) {
				int vertex = queue.poll();
				list.add(vertex);
				
				for(int i = 1; i < V + 1; i++) {
					if(matrix[vertex][i] == 1) {
//						matrix[vertex][i]--;
						inDegree[i]--;
						
						if(inDegree[i] == 0) {
							queue.offer(i);
						}
					}
					
				}
			}
			
			int size = list.size();
			
			System.out.print("#" + index + " ");
			for(int i = 0; i < size; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
