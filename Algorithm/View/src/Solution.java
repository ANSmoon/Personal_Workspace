/*
 * Author : 문범수
 * Date : 2024-01-29
 * subject : 조건에 맞는 case 구별
 * name : ViewSub.java
 * duration : 40m
 * CodeNo : 1206
 */

import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for(int k = 1; k < 11; k++) {
			int arr[] = new int[sc.nextInt()];
			int max = 0;
			int cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max)
					max = arr[i];
			}
			
			// 배열 생성
			int matrix[][] = new int[max][arr.length];

			for (int i = 0; i < arr.length; i++) {
				for (int j = arr[i] - 1; j >= 0; j--) {
					matrix[j][i] = 1;
				}
			}
			
			// 양쪽 검사 후 갯수 파악
			for (int i = 2; i < arr.length - 2; i++) {
				for (int j = 0; j < max; j++) {
					if (matrix[j][i] == 1 && matrix[j][i - 1] + matrix[j][i - 2] + matrix[j][i + 1] +
							 matrix[j][i + 2] == 0) {
						cnt++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", k, cnt);
		}
		sc.close();
	}
}
