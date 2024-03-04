/*
 * Author : 문범수
 * Date : 2024-02-05
 * subject : 뒤로가기 구현
 * main : 입력값에 따라 stack 구현
 * name : Zero.java
 * duration : 15m
 * CodeNo : 8931
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 전체 테스트 케이스 입력 + index 선언
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			// 각 케이스 별 전체 갯수
			// 전체 합 변수 및 입력받을 임시 변수 선언
			int size = Integer.parseInt(reader.readLine());
			int sum = 0;
			int temp = 0;
			Stack<Integer> stack = new Stack<>();
			
			// 각 케이스 만큼 입력 받고, pop까지 시행
			for (int i = 0; i < size; i++) {
				temp = (Integer.parseInt(reader.readLine()));
				// 입력 값이 0인지 아닌지 구분 하면서 push, pop 결정
				if (temp > 0) {
					stack.push(temp);
				}else {
					if(!stack.empty()) {
						stack.pop();	
					}
				}
			}
			// 남아있는 stack에서 꺼내면서 합산
			while(!stack.empty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + index + " " + sum);
			index++;
		}

	}
}
