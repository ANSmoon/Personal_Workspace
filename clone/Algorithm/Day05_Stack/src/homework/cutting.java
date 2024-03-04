/*
 * Author : 문범수
 * Date : 2024-02-05
 * subject : 사다리 경로 추적
 * main : 
 * name : Cutting.java
 * duration : 10m
 * CodeNo : 1210
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class cutting {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 전체 케이스 입력 및 index 선언
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		// 케이스 수 만큼 선언
		while(index <= total) {
			int sum = 0; // 전체 잘라진 개수
			int cnt = 0; // 레이저 개수 세기 용
			Stack<Character> stack = new Stack<>();
			char x = 0;
			
			// 문자열로 입력받기
			String str = reader.readLine();
			// 쇠막대기 열려있는 지점을 기준으로 레이저 갯수 세기 => 닫힐 때 까지
			int[] count = new int[str.length()];
			
			// 각 문자열 문자로 형태 전환 하면서 stack 삽입
			// 단순 삽입이 아닌 레이저와 막대기 구분 필요
			// 레이저는 ()이 붙어있다.
			// 막대기는 떨어져 있다.
			// 막대기 내에 () 개수만 구할 수 있다면
			// 잘려진 갯수를 구할 수 있다.
			// 원리 : count 활용 => 잘려진 갯수 = 막대기 내 레이져 갯수 + 1
			// 두가지의 경우 ( 다음에 (가 이어지는 경우와 )가 바로 나오는 경우
			// count 배열을 만들자
			
			
			for(int i = 0; i < str.length(); i++) {
				x = str.charAt(i);
				if(x == '(') {
					stack.push(x);
					
				}else {
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}
				
			}
			
			
			
			System.out.println("#" + index + " " + sum);
			index++;
		}
	}
}
