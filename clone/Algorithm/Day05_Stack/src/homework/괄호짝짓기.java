/*
 * Author : 문범수
 * Date : 2024-02-05
 * subject : 사다리 경로 추적
 * main : 괄호는 여는 부분과 닫는부분이 일치해야 하며 순서가 바뀐 경우는 
 * 이미 유효한 식이 아니기 때문에 고려 대상이 아니다.
 * name : 사다리.java
 * duration : 10m
 * CodeNo : 1210
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		int index = 1;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		

		while (index < 11) {
			Stack<Character> stack = new Stack<>();
			int total = Integer.parseInt(reader.readLine());
			String str = reader.readLine();
			int result = -1;
			char comparison = 0;

			for (int i = 0; i < total; i++) {
				char x = str.charAt(i);
				if (x == '{' || x == '[' || x == '(' || x == '<') {
					stack.add(x);
				} else {
					if(!stack.empty()) {
						comparison = stack.pop();
						if ((comparison == '{' && x == '}') || (comparison == '(' && x == ')')
								|| (comparison == '<' && x == '>') || (comparison == '[' && x == ']')) {
							result = 1;
						} else {
							result = 0;
							break;
						}
					}else {
						result = 0;
						break;
					}
				}				
			}
			System.out.println("#" + index + " " + result);
			index++;
		}
	}
}
