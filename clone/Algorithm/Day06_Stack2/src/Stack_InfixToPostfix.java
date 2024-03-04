import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Stack_InfixToPostfix {
	public static void main(String[] args) {
		// Stack 내 우선순위 비교를 위한 생성
		Map<Character, Integer> prior = new HashMap<>();
		
		prior.put('+', 1);
		prior.put('-', 1);
		prior.put('*', 2);
		prior.put('/', 2);
		prior.put('(', 0);
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		// 중위 표기식 -> 후위 표기식
		String postfix = "";
		Stack<Character> operand = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			
			if(x == '(') {
				operand.push(x);
			}else if(x == ')') {
				while(operand.peek() != '(') {
					postfix += operand.pop();
				}
				operand.pop();
			}else if('0' <= x && x <= '9') {
				postfix += x;
			}else {
				// +, -, *, /
				if(operand.isEmpty()) {
					operand.push(x);
				}else {
					// 우선순위가 낮은 연산자가 마지막에 위치할 때까지 pop
					while(!operand.isEmpty() && prior.get(x) <= prior.get(operand.peek())) {
						postfix += operand.pop();
					}
					operand.push(x);
				}
			}
		}
//		postfix += operand.pop();
		System.out.println(postfix);
	}
}
