/*
 * Author : 문범수
 * Date : 2024-02-27
 * subject : 재귀함수 활용
 * main : 부분집합 구현
 * issue : Indexing 활용
 * name : hamburger.java
 * duration : 150m
 * CodeNo : 5215
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hamburger {
	public static StringTokenizer token;
	public static int N; // 재료의 수
	public static int L; // 제한 칼로리
	public static int[][] arr; // 각 재료의 맛 점수 및 칼로리
	public static int result; // 조합의 결과가 저장된 배열(맛 점수만 저장)
	public static boolean check[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			L = Integer.parseInt(token.nextToken());
			arr = new int[1 << N][2];
			
			// 맛과 칼로리를 나타내는 배열 저장
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				arr[i][0] = Integer.parseInt(token.nextToken());
				arr[i][1] = Integer.parseInt(token.nextToken());
			}

			// 순열로 열량을 넘지 않는 경우 탐색
			check = new boolean[N];
			result = 0; // test case가 많이 들어올 경우 초기화 필요
			powerSet(0, 0, 0);

			System.out.println("#" + index + " " + result);
			index++;
		}
	}

	public static void powerSet(int idx, int max, int cal) {
		// base case
		if (cal > L) { // 칼로리가 넘는 경우는 return;
			return;
		}
		if (idx >= N) { // 조건에 해당하는 경우 값 할당
			if (max > result) {
				result = max;
			}
			return;
		}
		
		// 어떤 재료가 선택되었는지는 중요하지 않기 때문에 각 더하고 조건에 맞는 상황인 경우에만 값을 전달하면 된다.
		// recursive case
		powerSet(idx + 1, max + arr[idx][0], cal + arr[idx][1]);
		powerSet(idx + 1, max, cal);
	}
}
