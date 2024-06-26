/*
 * Author : 문범수
 * Date : 2024-01-30
 * subject : 최대, 최소
 * name : Solution.java
 * duration : 60m
 * CodeNo : 1208
 */

package homework;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = 1;

		while (times < 11) {
			int total = sc.nextInt();
			int[] arr = new int[100];
			int min, max;
			int max_index = 0;
			int min_index = 0;
			int dif = 0;

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < total; i++) {
				max = -1;
				min = 1000;
				for (int j = 0; j < arr.length; j++) {
					if (max < arr[j]) {
						max = arr[j];
						max_index = j;
					}
					if (min > arr[j]) {
						min = arr[j];
						min_index = j;
					}
				}
				arr[max_index] -= 1;
				arr[min_index] += 1;
				max = -1;
				min = 1000;
				for (int j = 0; j < arr.length; j++) {
					if (max < arr[j]) {
						max = Math.max(max, arr[j]);
					}
					if (min > arr[j]) {
						min = Math.min(min, arr[j]);
					}
				}
				dif = max - min;
			}
			System.out.printf("#%d %d\n", times, dif);
			times++;
		}
		sc.close();
	}
}
