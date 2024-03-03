/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 
 * page : https://www.acmicpc.net/problem/1244
 * main : 0과 1을 규칙에 맞게 반전시키기
 * issue : indexing이 1부터 시작한다는 점을 실수하지 말자 && 시작위치 실수
 * name : b_1244.java
 * duration : 60m
 * no : 1244
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());

		// 스위치 배치
		int[] arr = new int[total + 1];
		for (int i = 1; i < total + 1; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}

		// 총 사람 수
		int N = Integer.parseInt(reader.readLine());

		// 인적사항 입력
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(reader.readLine());
			int gender = Integer.parseInt(token.nextToken());
			int locate = Integer.parseInt(token.nextToken()); // index에 맞게 수정

			// 남자 여자에 따른 로직 상이
			if (gender == 1) { // 남자일 경우 배수 스위치 반전
				for (int j = locate; j < total + 1; j += locate) {
					arr[j] = (arr[j] + 1) % 2; // 0 과 1 스위치 방법
				}
				// 여자인 경우
				// locate 중심으로 좌우 대칭이면서 가장 많은 스위치 포함하는 구간 탐색 => 모두 변경
			} else {
				int left = locate - 1;
				int right = locate + 1;

				while (left >= 1 && right < total + 1) {
					// 대칭이 아닐 경우 빠져나온다.
					if (arr[left] != arr[right]) {
						break;
					}
					// 대칭인 경우 다음칸으로 이동
					else if (arr[left] == arr[right]) {
						left -= 1;
						right += 1;
					}
				}

				// 원상복구
				left += 1;
				right -= 1;
				for (int j = left; j <= right; j++) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
		}

		// 출력 조건 주의
		int cnt = 0;
		for (int i = 1; i < total + 1; i++) {
			if (cnt == 20) {
				System.out.println();
				cnt = 0;
			}
			System.out.print(arr[i] + " ");
			cnt++;
		}

	}
}
