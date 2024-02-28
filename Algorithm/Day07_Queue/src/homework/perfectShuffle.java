/*
 * Author : 문범수
 * Date : 2024-02-07
 * subject : 두개의 queue에 홀수개와 짝수개의 상황에 맞게 삽입 가능한지
 * main : Linear Queue 구현
 * name : perfectShuffle.java
 * duration : 30m
 * CodeNo : 3499
 */

package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class perfectShuffle {
	public static void main(String[] args) {
		// 절반씩 queue 사용
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		
		// 전체 케이스 입력
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int index = 1;
		
		// 반복문 시작
		while(index <= total){
			// 전체 문자 길이 입력
			int len = sc.nextInt();
			
			// 두개의 queue에 문자열 입력(문자 길이 절반씩)
			// 홀짝 경우 구분
			for(int i = 0; i < len; i++) {
				if(len % 2 == 0) {
					if(i < len / 2) {
						queue1.add(sc.next());
					}else {
						queue2.add(sc.next());
					}
				}else { // 홀수일때는 queue1에 하나 더 저장 
					if(i <= (len / 2)) {
						queue1.add(sc.next());
					}else {
						queue2.add(sc.next());
					}
				}
			}
			
			// 담겨있는 정보들을 1회 반복문에서 하나씩 출력
			System.out.print("#" + index + " ");
			for(int i = 0; i < len; i++) {
				if(i % 2 == 0) {
					System.out.print(queue1.poll() + " ");
				}else if(i % 2 == 1) {
					System.out.print(queue2.poll() + " ");
				}
			}
			System.out.println();
			index++;
		}
		sc.close();
	}
}
