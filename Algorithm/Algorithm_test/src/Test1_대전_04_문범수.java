/*
 * main : stack과 유사한 방식의 추가를 통해 승리 조건 탐색
 * subject : 승리 조건에 부합하는 결과 출력
 * author : 문범수
 * issue : 탐색과정에서 indexing이 잘못된 것으로 판단됨.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1_대전_04_문범수 {
	public static int[][] matrix = new int[6][7]; // 현재 상태를 나타낼 배열 선언
	public static int result; // 결과값
	public static StringTokenizer token;
	public static int cnt; // 연속으로 있는 갯수 파악
	public static int[][] arr = new int[7][2]; // 공을 놓을 수 있는 위치의 index 저장 배열
	public static int row; // 공을 놓을 수 있는 row
	public static int col; // 공을 놓을 수 있는 col
	public static boolean find; // 위치를 찾았을 경우 빠져나올 기저 변수

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			// 2차원 배열에 현재 상태 저장
			for (int i = 0; i < 6; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 7; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			// 놓을 수 있는 위치는 공이 놓여있는 위 or 맨아래
			// 즉 7개의 위치만 가능하다. -> 먼저 탐색
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

			// arr 7개만 탐색하면서 해당 위치로부터 8방 탐색 실시
			// 높은 숫자부터 탐색하여 이길 경우의 수가 많을 경우 높은 케이스 출력하도록 설정
			for (int i = 6; i >= 0; i--) {
				find = false;
				row = arr[i][0];
				col = arr[i][1];
				result = -1;
				// 탐색 범위 제한
				// 위쪽은 탐색 필요 없음
				int tmp1 = row;
				int tmp2 = col;
				cnt = 0;
				// 오른쪽 위
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp1 -= 1;
					tmp2 += 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp1 - 1 >= 0 && tmp2 + 1 < 7 && matrix[--tmp1][++tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 오른쪽
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp2 += 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp2 + 1 < 7 && matrix[tmp1][++tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 오른쪽 아래
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp1 += 1;
					tmp2 += 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp1 + 1 < 6 && tmp2 + 1 < 7 && matrix[++tmp1][++tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 아래
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp1 += 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp1 + 1 < 6 && matrix[++tmp1][tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 왼쪽 아래
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp1 += 1;
					tmp2 -= 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp1 + 1 < 6 && tmp2 - 1 >= 0 && matrix[++tmp1][--tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 왼쪽
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp2 -= 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp2 - 1 >= 0 && matrix[tmp1][--tmp2] == 0) {
							result = col;
							break;
						}
					} else {
						cnt = 0;
						break;
					}
				}
				if (find == true) {
					break;
				}

				// 왼쪽 위
				while (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7) {
					tmp1 -= 1;
					tmp2 -= 1;
					if (tmp1 >= 0 && tmp1 < 6 && tmp2 >= 0 && tmp2 < 7 && matrix[tmp1][tmp2] == 1) {
						cnt++;
						if (cnt == 3 && tmp1 - 1 >= 0 && tmp1 - 2 >= 0 && matrix[--tmp1][--tmp2] == 0) {
							result = col;
							find = true;
							break;
						}
					} else {
						cnt = 0;
						break;
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
