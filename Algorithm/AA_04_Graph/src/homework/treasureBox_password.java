/*
 * Author : 문범수
 * Date : 2024-03-26
 * subject : 
 * main : 
 * issue : 우선순위큐가 정렬되지 않는 문제 발생 => 우선순위큐에 대한 정의 부족
 * name : treasureBox_password.java
 * duration : 60m
 * CodeNo : 5658
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class treasureBox_password {
	static String str;
	static char[] select;
	static String[] ans;
	static int N, K, total;
	static long result;
	static StringTokenizer token;
//	static PriorityQueue<Long> pq; // 우선순위 queue 선언
	static List<Long> list;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken()); // 총 숫자 갯수
			K = Integer.parseInt(token.nextToken()); // 뽑아야 하는 순서
			result = 0;
			str = reader.readLine(); // 처음 문장을 받을 배열
			list = new ArrayList<>();
			
			rotation(str, N);
			calculator(ans, K);

			System.out.println("#" + index + " " + result);
		}
	}

	static void rotation(String str, int N) {
		ans = new String[N]; // 최대 N개의 가짓수가 나온다.
		int cnt = 0;

		// 생성 가능한 문자 처리
		for (int k = 0; k < (N / 4); k++) {
			// 원래 문장에서 3개씩 추출해서 ans 문자열에 저장
			for (int i = 0; i < N; i = i + (N / 4)) {
				ans[cnt++] = str.substring(i, i + (N / 4));
			}
			// 맨앞 문자를 맨 뒤로 옮기는 방식
			char first = str.charAt(0);
			str = str.substring(1); // begin (1) 부터 끝까지 문자를 가져옴
			str = str + first;
		}
	}

	static void calculator(String[] ans, int k) {
		String tmp;

		// list에 삽입
		for (String s : ans) {
			tmp = s;
			if(!list.contains(Long.parseLong(tmp,16)) && Long.parseLong(tmp, 16) > 0) {
				list.add(Long.parseLong(tmp, 16));
			}
		}

		list.sort(Collections.reverseOrder());
		
		// k번째 값 추출
		result = list.get(k - 1);
	}
}