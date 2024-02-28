/*
 * Author : 문범수
 * Date : 2024-02-15
 * subject : Heap 구현
 * main : PriorityQueue 구현
 * issue : 탈출조건이 부적절했음
 * name : heap.java
 * duration : 60m
 * CodeNo : 2930
 */
package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class heap {
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		// 반복문 시작
		while (index <= total) {
			// 우선순위 Queue
			// 내림차순 정렬 => MaxHeap 형태
//			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
//				return b - a;
//			});
			
			// collection에 역정렬 존재
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			int N = Integer.parseInt(reader.readLine()); // 연산 수
			
			System.out.print("#" + index + " ");
			
			for (int i = 0; i < N; i++) { // 필요 연산 수 만큼 읽기
				token = new StringTokenizer(reader.readLine());
				if (token.nextToken().equals("1")) { // token이 2개 들어 있을 때 => 추가 연산
					maxHeap.offer(Integer.parseInt(token.nextToken()));
				} else { // token이 1개 들어 있을 때 -> 제거 연산
					if (!maxHeap.isEmpty()) {
						System.out.print(maxHeap.poll() + " ");
					} else {
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println();
			index++;
		}
	}
}
