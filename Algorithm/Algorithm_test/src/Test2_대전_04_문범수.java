/*
 * main : Queue를 활용한 문제
 * subject : 가능한 경우에 대해서 확인하는 방법 탐구
 * author : 문범수
 * issue : 불가능한 경우를 어떻게 구현할 지 구체화
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2_대전_04_문범수 {
	public static int N; // 전역 변수 N
	public static int M; // 전역 변수 M
	public static int K; // 전역 변수 K
	public static StringTokenizer token;
	public static int cnt; // 필요 회전 수
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		while(index <= total) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			// queue 3개를 동시에 선언하고 동시에 돌면서 탐색
			Queue<Integer> queue1 = new LinkedList<>();
			Queue<Integer> queue2 = new LinkedList<>();
			Queue<Integer> queue3 = new LinkedList<>();
			
			// 각 queue에 알맞게 삽입
			token = new StringTokenizer(reader.readLine());
			for(int i = 0; i < N; i++) {
				queue1.offer(Integer.parseInt(token.nextToken()));
			}
			token = new StringTokenizer(reader.readLine());
			for(int i = 0; i < M; i++) {
				queue2.offer(Integer.parseInt(token.nextToken()));
			}
			token = new StringTokenizer(reader.readLine());
			for(int i = 0; i < K; i++) {
				queue3.offer(Integer.parseInt(token.nextToken()));
			}
			cnt = 0;
			while(true) {
				queue1.offer(queue1.poll()); // 각 queue에서 하나씩 뺀 뒤 다시 삽입
				queue2.offer(queue2.poll());
				queue3.offer(queue3.poll());
				cnt++; // 1회전 마다 cnt + 1 진행
				if(queue1.peek() == queue2.peek() && queue1.peek() == queue3.peek() && queue2.peek() == queue3.peek()) {
					break;
				}
				if(cnt > 1000000000) { // 불가능한 경우 : 가능한 경우의 수를 최대로 둔 뒤 해당 경우의 수까지 발견하지 못하면 -1 출력
					cnt = -1;
					break;
				}
			}
			
			System.out.println("#" + index + " " + cnt);
			index++;
		}
	}
}
