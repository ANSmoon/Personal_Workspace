/*
 * Author : 문범수
 * Date : 2024-01-31
 * subject : 오름차순 정렬 및 조건
 * name : Solution.java
 * duration : 30m
 * CodeNo : 19557
 */

package gravity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// BufferedReader 받기 연습
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());
		int x = 1;

		while (x <= total) {
			int index = Integer.parseInt(reader.readLine());
			String str = reader.readLine();

			// StringTokenizer => delimiter를 기준으로 분리할 때 사용
			// 클래스 파라미터에는 문자열 입력(변수로도 입력 가능)
			StringTokenizer token = new StringTokenizer(str);

			// countTokens 남아있는 token 갯수 반환
			int[] arr = new int[index];

			// hasMoreTokens => token이 남아있는지 여부 확인
			// nextToken => 다음 token 탐색
			int ch = 0;
			while (token.hasMoreTokens()) {
				arr[ch++] = Integer.parseInt(token.nextToken());
			}

			// Arrays.toString => 배열의 문자열 변환 출력
//			System.out.println(Arrays.toString(arr));
			
			
			// logic : 1) 가장 높은 위치의 상자만 고려 => 열마다 한번씩만 계산
			//         2) 각 위치에서 맨 마지막 열까지의 거리 계산
			//		   3) 중간에 본인 높이 이상의 건물 있을 시 max값 감소
			int[] maxArr = new int[arr.length-1];
			int big = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > 0) {
					maxArr[i] = arr.length - 1 - i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[i] <= arr[j] && maxArr[i] > 0) {
							maxArr[i]--;
						}
					}
				}
				
				big = Math.max(maxArr[i], big);
			}
			System.out.printf("#%d %d\n", x, big);
			x++;
		}
	}
}
