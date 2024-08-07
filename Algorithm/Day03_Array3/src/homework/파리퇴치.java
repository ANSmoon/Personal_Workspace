/*
 * Author : 문범수
 * Date : 2024-01-31
 * subject : 방향탐색
 * name : Solution.java
 * duration : 57m
 * CodeNo : 2001
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 전체 cycle 수 입력
		int total = Integer.parseInt(reader.readLine());
		int z = 1;

		while (z <= total) {
			// 두번째 라인에서 N M 입력
			String second = reader.readLine();

			int N = 0;
			int M = 0;

			StringTokenizer token = new StringTokenizer(second);
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());

			// N M 을 토대로 2차원 배열 선언
			int[][] arr = new int[N][N];

			// 선언된 배열에 줄마다 입력을 받아 삽입
			for (int i = 0; i < N; i++) {
				String third = reader.readLine();
				token = new StringTokenizer(third);
				for (int j = 0; j < N;) {
					while (token.hasMoreTokens()) {
						arr[i][j++] = Integer.parseInt(token.nextToken());
					}
				}
			}

			// 행렬 탐색 : left, up 만 살펴본다.
			// => 시작점을 제한함으로써 왼쪽위로 넓어지는 구역만 살피도록 구현
			int sum;
			int max = 0;
			// 먼저 각 지점 탐색 제한
			for (int i = M - 1; i < arr.length; i++) {
				for (int j = M - 1; j < arr.length; j++) {
					int up = i;
					int left = j;
					sum = 0;
					
					// 각 지점에서 왼쪽 위 지역 탐색
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							sum += arr[up][left];
							left -= 1;
						}
						up -= 1;
						left = j;
					}
					max = Math.max(sum, max);
				}
			}
			System.out.printf("#%d %d\n", z, max);
			z++;
		}
		reader.close();
	}
}
