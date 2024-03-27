/*
 * Author : 문범수
 * Date : 2024-03-27
 * subject : dfs & dp
 * main : Combination 사용
 * issue : 꼭 3달이 연속인 날이 필요한 건 아니다!
 * name : swimmingPool.java
 * duration : 90m
 * CodeNo : 1952
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swimmingPool {
	static int result, cnt, min, size; // 결과, 총 개월 수
	static int[] cost; // 비용 배열
	static int[] month; // 이용 계획 배열
	static StringTokenizer token;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			result = Integer.MAX_VALUE;
			cnt = 0;
			cost = new int[4];
			list = new ArrayList<>();

			// 비용 4개 저장
			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(token.nextToken());
			}

			// 월별 계획 저장
			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < 12; i++) {
				int tmp = Integer.parseInt(token.nextToken());
					list.add(tmp);
			}
			
			check(0, 0);
			result = Math.min(result, cost[3]); // 1년 이용권과 금액 비교

			System.out.println("#" + index + " " + result);
		}
	}

	static void check(int cnt, int sum) {
		if (cnt >= 12) {
			result = Math.min(result, sum);
			return;
		}
		
		check(cnt + 1, sum + (list.get(cnt) * cost[0])); // 하루 이용권 사용
		check(cnt + 1, sum + cost[1]); // 한달 이용권 사용
		if(cnt < 10) {
			check(cnt + 3, sum + cost[2]); // 3달 이용권 사용
		}
	}
}
