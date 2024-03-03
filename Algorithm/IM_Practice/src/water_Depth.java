/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 단일 탐색
 * main : 8방 탐색
 * issue : 입력 실수 [replace, trim]
 * name : water_Depth.java
 * duration : 55m
 * CodeNo : 7236
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class water_Depth {
	static int N, ans, row, col, max;
	static String[] arr;
	static StringTokenizer token;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {

			max = 0;
			N = Integer.parseInt(reader.readLine());
			arr = new String[N];
			
			// 배열 삽입
			for (int i = 0; i < N; i++) {
				arr[i] = reader.readLine().replace(" ", "");
			}
			

			// 판별
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = 0;
					if (arr[i].charAt(j) == 'G') {
						continue;
					} else {
						// 8방 탐색
						for (int k = 0; k < 8; k++) {
							row = i + dr[k];
							col = j + dc[k];
							if (row >= 0 && row < N && col >= 0 && col < N && arr[row].charAt(col) == 'W') {
								ans++;
							}
						}
						if (ans == 0) {
							ans = 1;
						}
						if (max <= ans) {
							max = ans;
						}
					}
				}
			}

			System.out.println("#" + index + " " + max);
			index++;
		}
	}
}
