/*
 * Author : 문범수
 * Date : 2024-02-07
 * subject : 경우의 수 찾기
 * main : count 배열 저장 및 출력
 * name : cardGame.java
 * duration : 15m
 * CodeNo : 7102
 */

package homework;

import java.util.Scanner;

public class cardGame {
	public static void main(String[] args) {
		// 전체 테스트 케이스 개수 입력
		Scanner sc = new Scanner(System.in);

		// 전체, index, N, M 변수 선언
		int total = sc.nextInt();
		int index = 1;
		int N = 0;
		int M = 0;

		// 1. 반복 시작
		while (index <= total) {
			// 이중 반복문으로 나올 수 있는 합 갯수 배열 저장
			// 배열 크기 = n * m
			N = sc.nextInt();
			M = sc.nextInt();
			int[] count = new int[N + M + 1]; // 2 ~ N + M 까지
			int max = 0; // 최댓값 비교용 변수

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					count[i + j]++;
				}
			}

			// 나올 수 있는 합의 가장 큰 횟수 저장
			for (int i = 0; i < count.length; i++) {
				if (max < count[i])
					max = count[i];
			}

			// 출력부 : 해당 횟수와 같은 index 출력
			System.out.print("#" + index + " ");
			for (int i = 0; i < count.length; i++) {
				if (max == count[i])
					System.out.print(i + " ");
			}
			System.out.println();
			index++;
		}
		sc.close();
	}
}