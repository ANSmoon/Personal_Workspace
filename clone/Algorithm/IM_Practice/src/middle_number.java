/*
 * Author : 문범수
 * Date : 2024-02-20
 * subject : 최대 최소 탐색
 * main : 평균값 처리
 * issue : 소수점 관리가 살짝 걸렸음
 * name : middle_number.java
 * duration : 17m
 * CodeNo : 1984
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class middle_number {
	public static int min;
	public static int max;
	public static int min_index;
	public static int max_index;
	public static double result;
	public static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		while(index <= total) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			int x = 0;
			arr = new int [10];
			result = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			while(token.hasMoreTokens()) {
				arr[x++] = Integer.parseInt(token.nextToken());
			}
			
			for(int i = 0; i < 10; i++) {
				if(arr[i] > max) {
					max = arr[i];
					max_index = i;
				}
				if(arr[i] < min) {
					min = arr[i];
					min_index = i;
				}
			}
			arr[max_index] = 0;
			arr[min_index] = 0;
			
			for(int i = 0; i < 10; i++) {
				result += arr[i];
			}
			result = Math.round((result / 8));
			System.out.println("#" + index + " " + (int)result);
			index++;
		}
	}
}
