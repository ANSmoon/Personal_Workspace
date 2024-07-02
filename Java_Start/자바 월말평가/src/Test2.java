/*
author : 문범수
date : 2024-01-29
subject : Min, Max
name : Test2.java
*/

public class Test2 {
	public static void main(String[] args) {
		// 사용자 임의 배열 설정
		int[] arr = { -11, -12, -13, 11, 12, 13 };

		// 최대, 최소 초기화
		int min = 100;
		int max = -100;

		// 최대, 최소 index 초기화
		int index_min = 0;
		int index_max = 0;

		// 첫번째 반복문에서 배열 내 최대, 최솟값 탐색
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
			if (arr[i] <= min) {
				min = arr[i];
			}
		}

		// 해당 원소가 위치한 index 탐색
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max)
				index_max = i;
			if (arr[i] == min)
				index_min = i;
		}

		// 각 index 간의 차이를 절댓값으로 표현
		System.out.println(Math.abs(index_max - index_min));
	}
}
