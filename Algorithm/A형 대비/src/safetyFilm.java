/*
 * Author : 문범수
 * Date : 2024-04-03
 * subject : 부분집합 => 부분수열
 * main : 완전탐색(순열 + 부분집합)
 * issue : 부분집합 구현 이슈
 * name : safetyFilm.java
 * duration : 180m
 * CodeNo : 2112
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class safetyFilm {
	static int D, W, K, result; // D : 보호필름두께, W : 가로크기, K : 합격기준, 최소 약품 투입 횟수
	static int[][] matrix;
	static int[][] copyMatrix;
	static StringTokenizer token;
	static boolean pass;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			matrix = new int[D][W];
			copyMatrix = new int[D][W];
			result = Integer.MAX_VALUE;

			// 행렬 입력 받기
			for (int i = 0; i < D; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < W; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					copyMatrix[i][j] = matrix[i][j];
				}
			}

			// 약물 투입 전 check
			if (check()) {
				result = 0;
			} else { // 약물 투입 필요
				// 현재 row 위치 / 투입한 갯수
				change(0, 0);
			}
			System.out.println("#" + index + " " + result);
		}
	}

	// 부분집합으로 특정줄을 선택하는 로직
	// 색깔 경우의 수 추가(색깔이 2가지이기 때문에)

	static void change(int row, int inputCnt) {
		if (result <= inputCnt) {
			return;
		}

		// 끝지점에 도달한 경우
		if (row == D) {
			if (check()) { // 검사
				result = Math.min(result, inputCnt);
			}
			return;
		}

		// 1. 아무것도 투약하지 않음
		change(row + 1, inputCnt);

		// 2. A 투약
		Arrays.fill(matrix[row], 0);
		change(row + 1, inputCnt + 1);

		// 3. B 투약
		Arrays.fill(matrix[row], 1);
		change(row + 1, inputCnt + 1);

		// matrix 복구
		for (int i = 0; i < W; i++) {
			matrix[row][i] = copyMatrix[row][i];
		}
	}

	// 현재 입력 상태가 통과 가능한지 확인하는 메소드
	// boolean 반환
	static boolean check() {
		int countA, countB;
		// 합격기준에 부합한지 확인
		// 열우선 탐색 실시
		for (int i = 0; i < W; i++) {
			countA = 0;
			countB = 0;
			for (int j = 0; j < D; j++) {
				if (matrix[j][i] == 0) {
					countA++;
					countB = 0;
				} else if(matrix[j][i] == 1){
					countB++;
					countA = 0;
				}
				// 최소 갯수를 충족했다면 그 즉시 그 줄을 탈출시킨다.
				if(countA >= K || countB >= K) {
					break;
				}
			}
			// 한줄 다 돈다음에 확인
			// A나 B 모두 최소 갯수를 넘기지 못한 경우 stop
			if (countA < K && countB < K) {
				return false;
			}
		}
		// 만약 테스트를 무사히 통과한다면 현재 투입 갯수가 최솟값
		return true;
	}
}