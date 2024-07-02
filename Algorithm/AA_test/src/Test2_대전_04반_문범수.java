/*
 * Author : 문범수
 * Problem : 장사의 달인
 * date : 2024 - 03 - 25
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2_대전_04반_문범수 {
	static int result, total, find, cnt, cnt1, cnt2, cnt3, max, row, col; // 각 일자별로 몇개씩 팔았는지 cnt 변수 설정
	static int[][] matrix;
	static int[] sorted1, sorted;
	static boolean[] visited;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		// 반복문 시작
		while (index <= total) {
			cnt = 0; // 총 물건 판매 갯수
			cnt1 = 0; // 1일차 물건 판매 갯수
			cnt2 = 0; // 2일차 물건 판매 갯수
			cnt3 = 0; // 3일차 물건 판매 갯수
			find = 0;
			matrix = new int[3][9]; // 행렬 선언
			visited = new boolean[9]; // 방문 행렬 초기화
			sorted = new int[3 * 9]; // 미리 정렬시킨 배열
			sorted1 = new int[3 * 9]; // 역정렬을 위한 임시 배열

			for (int i = 0; i < 3; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 9; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					sorted1[tmp++] = matrix[i][j];
				}
			}
			Arrays.sort(sorted1);

			// 크기가 정렬된 sorted 정리
			tmp = 0;
			for (int i = 26; i >= 0; i--) {
				sorted[tmp++] = sorted1[i];
			}

			// 완전 탐색을 통해 총 9개의 최대 판매액 물건을 찾는다.
			// 탐색은 크기가 가장 큰 물건을 확인 후 결과값에 더해준다.
			first : while (cnt < 9) {
				second : for (int i = 0; i < 3; i++) {
					third : for (int j = 0; j < 9; j++) {
						if (sorted[find] == matrix[i][j] && !visited[j]) { // 최댓값에 해당하는 물건을 찾았을 시
							if (i == 0 && cnt1 < 3) {
								result += sorted[find++];
								cnt++; // 판매 물건 갯수 증가
								visited[j] = true;
								cnt1++;
								continue first;
							}
							if (i == 1 && cnt2 < 3) {
								result += sorted[find++];
								cnt++; // 판매 물건 갯수 증가
								visited[j] = true;
								cnt2++;
								continue first;							}
							if (i == 2 && cnt3 < 3) {
								result += sorted[find++];
								cnt++; // 판매 물건 갯수 증가
								visited[j] = true;
								cnt3++;
								continue first;							}
						}
					}
				}
				find++;
			}
			System.out.println("#" + index + " " + result);
			index++;
		}
	}
}
