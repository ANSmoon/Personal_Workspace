/*
 * Author : 문범수
 * Date : 2024-04-01
 * subject : 
 * page : 
 * main : 
 * issue : 2가 남았을 경우 1을 넣어줘야 할때와 기다려야 할때 구분 필요
 * name : .java
 * duration : m
 * CodeNo : 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tree {
	static int result, N, max_height, max_count, cnt;
	static int[] treeArr;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			result = 0;
			N = Integer.parseInt(reader.readLine());
			treeArr = new int[N];
			max_count = 0;
			max_height = Integer.MIN_VALUE;
			cnt = 0;

			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < N; i++) {
				treeArr[i] = Integer.parseInt(token.nextToken());
				max_height = Math.max(max_height, treeArr[i]);
			}

			for (int i = 0; i < N; i++) {
				if (max_height == treeArr[i]) {
					max_count++;
				}
			}

			if (max_count == N) {
				result = 0;
			} else {
				watering(1);
			}
			System.out.println("#" + index + " " + result);
		}
	}

	static void watering(int day) {
		// base line
		if (cnt + max_count == N) {
			if(result == 0) {
				result = day - 1;
			}
			return;
		}

		// recursive line
		for (int i = 0; i < N; i++) {
			if (max_height - treeArr[i] > 2) {
				if (day % 2 == 0) {
					treeArr[i] += 2;
					watering(day + 1);
				} else {
					treeArr[i] += 1;
					watering(day + 1);
				}
			} else {
				if (max_height - treeArr[i] == 1) {
					if (day % 2 == 1) {
						treeArr[i] += 1;
						cnt++;
						watering(day + 1);
					} else {
						continue;
					}
				}
				if (max_height - treeArr[i] == 2) {
					if (day % 2 == 0) {
						treeArr[i] += 2;
						cnt++;
						watering(day + 1);
					} else {
						continue;
					}
				}
			}
		}
		// 쉬는날로 지정
		watering(day + 1);
	}
}