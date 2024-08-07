/*
 * Author : 문범수
 * Date : 2024-01-30
 * subject : 오름차순 정렬
 * name : Solution4.java
 * duration : 24m
 * CodeNo : 1966
 */

package homework;

import java.util.Scanner;

public class Solution4 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		// 전체 갯수 입력
		int total = sc.nextInt();
		// 시작 번호
		int x = 1;
		
		
		while (x <= total) {
			// 각 case별 횟수
			int test_case = sc.nextInt();
			int[] arr = new int[test_case]; // 정렬할 배열
			int[] count = new int[100];
			int[] sorted = new int[test_case];
			
			// 배열 입력 및 count 배열 입력
			for (int i = 0; i < test_case; i++) {
				arr[i] = sc.nextInt();
				count[arr[i]]++;
			}
			
			for(int i = 1; i < count.length; i++){
				count[i] += count[i-1];
			}
			
			for(int i = arr.length - 1; i >= 0; i--) {
				sorted[--count[arr[i]]] = arr[i];
			}

			System.out.printf("#%d ",x);
			for(int i = 0; i < sorted.length; i++) {
				System.out.printf("%d ",sorted[i]);
			}
			System.out.println();
			x++;
		}

	}
}
