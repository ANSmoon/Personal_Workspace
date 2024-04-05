/*
 * Author : 문범수
 * Date : 2024-04-05
 * subject : 부분집합 및 연산자 입력받은 결과 출력
 * page : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
 * main : 완전탐색(부분집합)
 * issue : switch case 구현 이슈
 * name : makeNumber.java
 * duration : 60m
 * no : 4008
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class makeNumber {
	static int N, max, min, result, before;
	static int[] operator = new int[4]; // 각 연산자의 갯수(+,-,*,/)
	static int[] operand;
	static int[] tmp; // 나올 수 있는 연산자 결과 저장
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복 시작
		for (int index = 1; index <= total; index++) {
			N = Integer.parseInt(reader.readLine()); // 계산에 이용될 피연산자 수
			result = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			operand = new int[N];
			tmp = new int[N - 1];

			// 연산자 입력
			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(token.nextToken());
			}

			// 피연산자 입력
			token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < N; i++) {
				operand[i] = Integer.parseInt(token.nextToken());
			}
			
			subset(0);
			result = max - min;
			System.out.println("#" + index + " " + result);
		}
	}

	static void subset(int depth) {
		// base line
		if (depth == N - 1) {
			int x = calculator(tmp);
			min = Math.min(min, x);
			max = Math.max(max, x);
		}

		before = -1;

		// recursive line
		for (int i = 0; i < 4; i++) {
			if (operator[i] != 0 && operator[i] != before) {
				tmp[depth] = i;
				operator[i]--;
				subset(depth + 1);
				operator[i]++;
			}
		}
	}

	// 결과 계산하기
	static int calculator(int[] tmp) {
		int x = operand[0];
		for (int i = 0; i < N - 1; i++) {
			switch (tmp[i]) {
			case 0:
				x += operand[i + 1];
				break;
			case 1:
				x -= operand[i + 1];
				break;
			case 2:
				x *= operand[i + 1];
				break;
			case 3:
				x /= operand[i + 1];
				break;
			}
		}
		return x;
	}
}
