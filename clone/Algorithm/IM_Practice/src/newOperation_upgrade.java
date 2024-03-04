/*
 * Author : 문범수
 * Date : 2024-02-22
 * subject : 
 * main : 
 * issue : 시간초과 발생
 * name : .java
 * duration : m
 * CodeNo : 1493
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class newOperation_upgrade {
	public static int result;
	public static StringTokenizer token;
	public static int[][] arr = new int[50001][2];
	public static int x;
	public static int y;
	public static int x_index;
	public static int y_index;
	public static int row;
	public static int col;
	public static boolean pass;
	public static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(token.nextToken());
			y = Integer.parseInt(token.nextToken());
			result = 0;
			pass = false;
			cnt = 1;

			// 각 숫자별로 행과 열 저장
			for (int i = 1; i < 50001; i++) {
				if (pass == false) {
					row = cnt;
					col = 1;
				}
				
				arr[i][0] = row--;
				arr[i][1] = col++;
				
				if (row >= 1 && col <= i) {
					pass = true;
					continue;
				} else{
					cnt++;
					pass = false;
				}
			}

			x_index = arr[x][0] + arr[y][0];
			y_index = arr[x][1] + arr[y][1];

			for (int i = 1; i < 50001; i++) {
				if (arr[i][0] == x_index && arr[i][1] == y_index) {
					result = i;
					break;
				}
			}

			System.out.println("#" + index + " " + result);
			index++;
		}

	}
}
