/*
 * Author : 문범수
 * Date : 2024-02-29
 * subject : BackTracking
 * main : DFS
 * issue : 행렬을 초기화 하는 과정에서 오류
 * name : queen.java
 * duration : 100m
 * CodeNo : 2806
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class queen {
	static int N;
	static int[][] matrix;
	static int[][] backup;
	static int cnt;
	static int[] dl = { 1, 0, -1 }; // 오른쪽 아래, 아래, 왼쪽 아래만 탐색

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


			N = Integer.parseInt(reader.readLine());
			cnt = 0;
			matrix = new int[N][N];
			pass(0, matrix);
			System.out.println(cnt);

	}

	public static void pass(int depth, int[][] matrix) {
		// base line
		if (depth >= N) {
			cnt++;
			return;
		}
		
		// recursive line
		// 가능한 지역을 남겨놓는게 중요!!
		// 이미 지정된 열은 넘김
		// 0번부터 N-1번 열까지 탐색
		for (int i = 0; i < N; i++) {
			// 행은 depth로 사용하면 된다.
			if (matrix[depth][i] == 0) { // 현재 갈수 있는 지점
				matrix[depth][i] += 1; // 체크 후 3방향 true 변환
				int tmp1 = depth;
				int tmp2 = i;
				for (int j = 0; j < 3; j++) { // 위치한 지점으로부터 3방향으로 true로 바꿔줌
					while (depth + 1 < N && i + dl[j] >= 0 && i + dl[j] < N) {
						depth += 1;
						i += dl[j];
						matrix[depth][i] += 1;
					}
					depth = tmp1;
					i = tmp2;
				}
				
				pass(depth + 1, matrix);
				matrix[depth][i] -= 1;
				for (int j = 0; j < 3; j++) { // 위치한 지점으로부터 3방향으로 true로 바꿔줌
					while (depth + 1 < N && i + dl[j] >= 0 && i + dl[j] < N) {
						depth += 1;
						i += dl[j];
						matrix[depth][i] -= 1;
					}
					depth = tmp1;
					i = tmp2;
				}
				
			}
		}
	}
}