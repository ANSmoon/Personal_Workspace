/*
 * Author : 문범수
 * Date : 2024-02-15
 * subject : sudoku 완성시키기
 * main : 효율적인 코드 작성
 * issue : 3 X 3 구역의 검사 부분 로직이 어려웠음
 * name : sudoku.java
 * duration : 80m
 * CodeNo : 1974
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sudoku {
	static int[][] arr;
	static int[] count;
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int idx = 1;

		// 반복문 시작
		while (idx <= total) {
			// 2차원 배열 생성 삽입
			// 입력 총 9줄
			arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				int index = 0;
				StringTokenizer token = new StringTokenizer(reader.readLine());
				while (token.hasMoreTokens()) {
					arr[i][index++] = Integer.parseInt(token.nextToken());
				}
			}

			result = test(arr) + sectionTest(arr);

			// true = 1, false = 0 출력
			if (test(arr) > 0 || sectionTest(arr) > 0 || result > 0) {
				System.out.println("#" + idx + " " + 0);
			} else {
				System.out.println("#" + idx + " " + 1);
			}
			idx++;
		}

	}

	// row & col 검사 결과 반환 method
	// false면 1 반환, true면 0 반환
	static int test(int[][] arr) {
		int ans = 0;
		// 행 검사

		for (int i = 0; i < 9; i++) {
			count = new int[10];
			for (int j = 0; j < 9; j++) {
				count[arr[i][j]]++;
				if (count[arr[i][j]] > 1) {
					ans = 1;
					break;
				}
			}
			if (ans == 1) {
				return ans;
			}
		}

		// 열 검사
		for (int i = 0; i < 9; i++) {
			count = new int[10];
			for (int j = 0; j < 9; j++) {
				count[arr[j][i]]++;
				if (count[arr[j][i]] > 1) {
					ans = 1;
					break;
				}
			}
			if (ans == 1) {
				return ans;
			}
		}

		return ans;
	}

	// false면 1 반환, true면 0 반환
	static int sectionTest(int[][] arr) {
		int total = 0;
		int ans = 0;
		int section = 0;
		int row = 0;
		// (0,0) (0,3) (0,6) (3,0) (3,3) (3,6) (6,0) (6,3) (6,6)
		// 배열로 저장을 해서 x, y 의 index를 가져오는 방식
		// 각 구역의 시작지점

//		for(int k=0; k<9; k++) {
//			
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 3; j++) {
//					
//				}
//			}
//		}

		while (total < 9) {
			count = new int[10];
			int col = 0;
			if (section == 1 || section == 2 || section == 4 || section == 5 || section == 7 || section == 8) {
				col += 3;
			}
			if (section == 3 || section == 6) {
				row += 3;
			}
			// 3 X 3 순회 탐색
			for (int i = row; i < row + 3; i++) {
				for (int j = col; j < col + 3; j++) {
					count[arr[i][j]]++;
					if (count[arr[i][j]] > 1) {
						ans = 1;
						break;
					}
				}
				if (ans == 1) {
					break;
				}
			}
			if (ans == 1) {
				return ans;
			}
			total++;
		}
		return ans;
	}
}
