/*
 * main : 8방 탐색 구현
 * subject : 승리 조건에 부합하는 결과 출력
 * author : 문범수
 * issue : 놓았을 때 주변 탐색을 통해 4개가 되는지 확인할 것
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_new {
	public static int[] dr = { -1, 0, 1, 1, 1, 0, -1 }; // 행 방향
	public static int[] dc = { 1, 1, 1, 0, -1, -1, -1 }; // 열 방향
	public static int result;
	public static int[][] matrix = new int[6][7];
	public static StringTokenizer token;
	public static int[][] arr = new int[7][2];
	public static int col;
	public static int row;
	public static int cnt; // 4개 되는지 확인용도
	public static boolean find;
	public static boolean block1;
	public static boolean block2;
	public static int dx1;
	public static int dy1;
	public static int dx2;
	public static int dy2;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {

			// matrix 삽입
			for (int i = 0; i < 6; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 7; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			// 공을 배치할 수 있는 좌표 총 7개 생성
			int tmp = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 6; j++) {
					if (matrix[j][i] == 0) {
						arr[tmp][0] = j;
						arr[tmp][1] = i;
					} else {
						break;
					}
				}
				tmp++;
			}
			int result = -1;

			// 공을 각 7자리에 둔 다음 7방 탐색(양방향)을 통해 4개의 공이 되는지 확인
			for (int i = 6; i >= 0; i--) {
				find = false;
				row = arr[i][0];
				col = arr[i][1];
				dx1 = row;
				dx2 = row;
				dy1 = col;
				dy2 = col;
				block1 = false;
				block2 = false;

				// 오른쪽 위 왼쪽 아래 탐색
				while (find == false) {
					if (dx1 - 1 >= 0 && dy1 + 1 < 7 && matrix[dx1 - 1][dy1 + 1] == 1) {
						dx1 += dr[0];
						dy1 += dc[0];
						cnt++;
					} else {
						block1 = true;
					}
					if (dx2 + 1 < 6 && dy2 - 1 >= 0 && matrix[dx2 + 1][dy2 - 1] == 1) {
						dx2 += dr[4];
						dy2 += dc[4];
						cnt++;
					} else {
						block2 = true;
					}

					if ((dx1 < 0 && dx2 >= 6 && dy1 >= 7 && dy2 < 0) || (block1 && block2)
							|| (block1 && dx2 >= 6 && dy2 < 0) || (block2 && dx1 < 0 && dy1 >= 7)) {
						dx1 = row;
						dx2 = row;
						dy1 = col;
						dy2 = col;
						cnt = 0;
						break;
					}

					if (cnt == 3) {
						result = col;
						find = true;
					}
				}

				// 오른쪽 왼쪽 탐색
				while (find == false) {
					if (dy1 + 1 < 7 && matrix[dx1][dy1 + 1] == 1) {
						dy1 += dc[1];
						cnt++;
					} else {
						block1 = true;
					}
					if (dy2 - 1 >= 0 && matrix[dx2][dy2 - 1] == 1) {
						dy2 += dc[5];
						cnt++;
					} else {
						block2 = true;
					}
					if ((dy1 >= 7 && dy2 < 0) || (block1 && block2) || (block1 && dy2 < 0) || (block2 && dy1 >= 7)) {
						dy1 = col;
						dy2 = col;
						cnt = 0;
						break;
					}
					if (cnt == 3) {
						result = col;
						find = true;
					}
				}

				// 오른쪽 아래 왼쪽 위 탐색
				while (find == false) {
					if (dx1 + 1 < 6 && dy1 + 1 < 7 && matrix[dx1 + 1][dy1 + 1] == 1) {
						dx1 += dr[2];
						dy1 += dc[2];
						cnt++;
					} else {
						block1 = true;
					}
					if (dx2 + 1 < 6 && dy2 - 1 >= 0 && matrix[dx2 - 1][dy2 - 1] == 1) {
						dx2 += dr[6];
						dy2 += dc[6];
						cnt++;
					} else {
						block2 = true;
					}
					if (dx1 >= 6 && dx2 < 0 && dy1 >= 7 && dy2 < 0 || (block1 && block2) || (block1 && dy2 < 0 && dy2 < 0)
							|| (block2 && dy1 >= 7 && dx1 >= 6)) {
						dx1 = row;
						dx2 = row;
						dy1 = col;
						dy2 = col;
						cnt = 0;
						break;
					}
					if (cnt == 3) {
						result = col;
						find = true;
					}
				}

				// 아래 탐색
				while (find == false) {
					if (dx1 + 1 < 6 && matrix[dx1 + 1][dy1] == 1) {
						dx1 += dr[3];
						cnt++;
					} else {
						break;
					}
					if (dx1 >= 6) {
						dx1 = row;
						cnt = 0;
						break;
					}
					if (cnt == 3) {
						result = col;
						find = true;
					}
				}

				if (find == true) {
					break;
				}
			}
			System.out.println("#" + index + " " + result);
			index++;
		}

	}
}
