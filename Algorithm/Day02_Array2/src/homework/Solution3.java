/*
 * Author : 문범수
 * Date : 2024-01-30
 * subject : 중간값 구하기
 * name : Solution3.java
 * duration : 10m
 * CodeNo : 2063
 */

package homework;

import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		
		// 전체 갯수
		int total = sc.nextInt();
		
		// 배열 생성
		int[] arr = new int[total];
		
		// 배열 입력
		for(int i = 0; i < total; i++) {
			arr[i] = sc.nextInt();
		}
		
		// selection sort 구현
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		
		// 중간값 출력 : 전체 길이의 절반
		System.out.println(arr[arr.length/2]);
		sc.close();
	}
}
