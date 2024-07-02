/*
 * Author : 문범수
 * Date : 2024-02-06
 * subject : 후위 연산 구현
 * main : Postfix
 * issue : 괄호가 없는 상황에 대해서 추가 조치가 필요 while 구문으로 stack 이 빌때까지 pop
 * name : Calculator1.java
 * duration : 60m
 * CodeNo : 1222
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator1 {
	public static void main(String[] args) throws Exception {
		// stack 2개, map 1개, reader 1개 객체 각각 생성
		Stack<Character> stack = new Stack<>(); // 집합용
		Stack<Integer> stack1 = new Stack<>(); // 계산용
		Map<Character, Integer> prior = new HashMap<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 우선순위 설정
		prior.put('(', 0);
		prior.put('+', 1);
		prior.put('*', 2);

		// 전체 케이스만큼 반복 시작
		int index = 1;
		while (index <= 10) {
			// 문자열 입력, 결과 변수 초기화, token 초기화, 전체 갯수
			// stack에 담길 조건 구현

			int len = Integer.parseInt(reader.readLine());
			String str = reader.readLine();

			String postfix = "";
			Character token = ' ';
			int result = 0;

			for (int i = 0; i < len; i++) {
				token = str.charAt(i);
				if (token == '(') { // ( 넣을때
					stack.push(token);
					continue;
				} else if (token == ')') { // ) 넣을때
					while (stack.peek() != '(') {
						postfix += stack.pop();
					}
					stack.pop();
					continue;
				} else if (0 <= Character.getNumericValue(token) && Character.getNumericValue(token) <= 9) { // 숫자 넣을때
					postfix += token;
					continue;
				} else { // 연산자 넣을 때
					if (stack.isEmpty()) {
						stack.push(token);
						continue;
					} else {
						while (!(stack.isEmpty()) && prior.get(token) <= prior.get(stack.peek())) { // 우선순위 비교
							postfix += stack.pop();
						}
						stack.push(token);
						continue;
					}

				}
			}
			while(!stack.isEmpty()) {
				postfix += stack.pop();
			}
			// 반복 시작
			// 계산 로직 구현

			for (int i = 0; i < postfix.length(); i++) {
				int x = 0;
				int y = 0;
				if (0 <= Character.getNumericValue(postfix.charAt(i))
						&& Character.getNumericValue(postfix.charAt(i)) <= 9) {
					stack1.push(Character.getNumericValue(postfix.charAt(i)));
					continue;
				} else if (postfix.charAt(i) == '+') {
					x = stack1.pop();
					y = stack1.pop();
					stack1.push(x + y);
					continue;
				}
			}
			result = stack1.pop();

			System.out.println("#" + index + " " + result);
			index++;
		}

	}
}
