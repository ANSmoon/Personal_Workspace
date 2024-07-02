/*
 * Author : 문범수
 * Date : 2024-02-06
 * subject : Postfix
 * main : 후위연산 구현
 * issue : 형변환에서 char 값으로 받으니 값이 짤린다 (char = 1byte)
 * name : Calculator3.java
 * duration : 150m
 * CodeNo : 1224
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator3 {
	public static void main(String[] args) throws Exception{
		// 1. 전체 케이스 10번
		// Stack 객체 생성 & Map 객체 생성
		// postfix 전환용 + 계산용
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stack1 = new Stack<>();
		Map<Character, Integer> prior = new HashMap<>();
		 
		// Map으로 구현할 것!
		// Map => <문자 형태, 정수 형태> : 각각의 연산자에 우선순위 부여
		// ( 같은 경우 peek() 을 통해 조건문을 작성
		// /의 숫자를 가져오기 위해선 prior.get(/) 실시
		// 연산자 우선 순위 : ([입력받을] > * / > + - > ([입력된]
		// 밖에있는 ( 는 우선순위가 높은데 안에 들어있는 ( 는 우선순위가 낮다.

		prior.put('*', 2);
		prior.put('+', 1);
		prior.put('(', 0);
		
		// BufferedReader 객체 생성
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int index = 1; // 인덱스 생성
		
		// 2. 반복문 시작
		while(index <= 10) {
			// 전체 갯수 입력
			int total = Integer.parseInt(reader.readLine());
			
			// 문자열 생성 및 읽기
			String str = new String();
			str = reader.readLine();
			// 토큰 생성
			char token = ' ';
			
			// postfix를 담을 문자열 생성
			String postfix = "";
			
			// 계산한 값 정수 변수 선언
			int result = 0;
			
			// 3. 상황별로 조건 구현
			// stack에 삽입 조건 구현
			
			// 4. stack 삽입 및 문자열 변환, 반복문 시작
			for(int i = 0; i < total; i++) {
				token = str.charAt(i);
				// 피연산자는 무조건 바로 문자열에 삽입
				if('0' <= token && token <= '9') {
					postfix += token;
					continue;
				}else if(token == '(') { // ( 는 바로 push
					stack.push(token);
					continue;
				}else if(token == ')') { // ')'를 만나면 '('를 만날 때 까지 pop
					while(stack.peek() != '(') {
						postfix += stack.pop();
					}
					stack.pop();
					continue;
				}else { // + * 일 경우
					// stack이 비어있는 경우 처리
					if((stack.isEmpty())) {
						stack.push(token);
						continue;
					}
					// top 연산자가 token보다 높을 시 token보다 낮은 연산자까지 pop
					// top 연산자가 token 보다 낮을 시 push
					// 비어지기 전까지 pop 진행
					else {
						while(!(stack.isEmpty()) && prior.get(token) <= prior.get(stack.peek())) {
							postfix += stack.pop();
						}
						stack.push(token);
						continue;
					}
				}
			}
//			 Stack 비어있는지 확인
//			if(!stack.isEmpty()) {
//				System.out.println("Stack 남아있다!~!~!~!~!");	
//				stack.clear();
//			}
//			else{
//				System.out.println("Stack is Empty");
//			}
			// 5. 완성된 postfix를 계산
			// 앞에서부터 피연산자만을 stack에 push
			// 연산자를 만나면 꼭 2개 pop 후에 계산한 값을 다시 push
			// 피연산자 2개 변수 선언
			// 위 과정 반복
			// 더이상 연산자가 없으면 마지막 부분 pop해서 결과값에 저장
			// 결과값 양식에 맞춰 출력
			for(int i = 0; i < postfix.length(); i++) {
				int x = 0;
				int y = 0;
				int temp = 0;
				if('0' <= postfix.charAt(i) && postfix.charAt(i) <= '9') {
					stack1.push(Character.getNumericValue(postfix.charAt(i)));
					continue;
				}
				// ***연산 순서도 중요하다. LIFO 구조를 생각해서 설계***
				// 연산자가 + * 밖에 없어서 별로 중요하지 않다.
				// 문자형 이기 때문에 - '0' 필요
				else if(postfix.charAt(i) == '+') {
					x = stack1.pop();
					y = stack1.pop();
					temp = x + y;
					stack1.push(temp);
					continue;
				}else if(postfix.charAt(i) == '*') {
					x = stack1.pop();
					y = stack1.pop();
					temp = x * y;
					stack1.push(temp);
					continue;
				}
			}
			
			result = stack1.pop();

			System.out.println("#" + index + " " + result);
			
			index++;
		}
	}
}
