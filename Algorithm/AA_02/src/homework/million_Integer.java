/*
 * Author : 문범수
 * Date : 2024-02-28
 * subject : pivot 설정 로직 다양화
 * main : Sorting
 * issue : Nope
 * name : million_Integer.java
 * duration : 32m
 * CodeNo : 14229
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class million_Integer {
	public static int[] A;

	public static void main(String[] args) throws Exception {
		// index 1부터 시작
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int index = 0;
		A = new int[1000000];

		while (token.hasMoreTokens()) {
			A[index++] = Integer.parseInt(token.nextToken());
		}

		quickSort(0, A.length - 1);
		System.out.println(A[500000]);

	}

	public static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right); // pivot 설정 logic 다양
			quickSort(left, pivot - 1); // 왼쪽 탐색
			quickSort(pivot + 1, right); // 오른쪽 탐색
		}
	}

	public static int partition(int left, int right) {
		int pivot = A[left]; // 왼쪽 끝을 pivot으로 지정
		int L = left + 1, R = right; // 시작 구간 -> pivot 1칸 옆

		while (L <= R) {
			// L : pivot 보다 큰 값을 찾을 때 까지 이동
			while (L <= R && A[L] <= pivot) {

				L++;
			} // R : pivot 보다 작거나 같은 값을 만날때까지 이동
			while (A[R] > pivot) {
				R--;
			}
			if (L < R) { // 만약에 교차가 이루어 졌다면 바꿀 이유가 없어짐
				int tmp = A[L];
				A[L] = A[R];
				A[R] = tmp;
			}
		} // 아까 설정한 pivot과 왼쪽영역의 가장 오른쪽 인자와 자리 교체
		int tmp = A[left];
		A[left] = A[R];
		A[R] = tmp;

		return R; // pivot 위치
	}
}