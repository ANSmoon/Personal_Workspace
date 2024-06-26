/*
 * Author : 문범수
 * Date : 2024-01-30
 * subject : 최빈수 구하기
 * name : Solution2.java
 * duration : 28m
 * CodeNo : 1204
 */

package homework;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 case 입력
		int total_case = sc.nextInt();
		int x = 0;
		
		while(x < total_case) {
			// 회차 index 입력
			x = sc.nextInt();
			
			int max = -1;
			int max_id = 0;

			// 비정렬 배열과 count 배열 생성
			int[] arr = new int[1000];
			int[] count = new int[101];
			
			// 1000개 원소 입력
			for(int i = 0; i < 1000; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 배열에서 count 추출
			for(int i = 0; i < arr.length; i++) {
				count[arr[i]]++;
				if(max <= count[arr[i]]) {
					max = count[arr[i]];
					max_id = arr[i];
				}
			}
			System.out.printf("#%d %d\n",x,max_id);
		}
		sc.close();
	}
}
