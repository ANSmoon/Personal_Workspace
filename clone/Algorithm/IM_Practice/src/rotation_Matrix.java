/*
 * Author : 문범수
 * Date : 2024-02-20
 * subject : 
 * main : 배열 회전
 * issue : 
 * name : .java
 * duration : m
 * CodeNo : 1961
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rotation_Matrix {
	public static int arr[][];
	public static int arr1[][];
	public static int arr2[][];
	public static int arr3[][];
	public static int N;
	public static int x;
	public static int y;
	public static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index < total) {
			N = Integer.parseInt(reader.readLine());
			arr = new int[N][N];
			for (int i = 0; i < 3; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			x = 0;
			y = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = arr.length - 1; j >= 0; j--) {
					arr1[x][y++] = arr[j][i];
				}
				x++;
				y = 0;
			}
			x = 0;
			y = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				for (int j = arr.length - 1; j >= 0; j--) {
					arr2[x][y++] = arr[i][j];
				}
				x++;
				y = 0;
			}
			x = 0;
			y = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				for (int j = 0; j < arr.length; j++) {
					arr3[x][y++] = arr[j][i];
				}
				x++;
				y = 0;
			}
			
			index++;
		}

	}
}
