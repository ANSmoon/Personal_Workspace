import java.util.Scanner;
import java.util.Stack;

public class Stack_실행취소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<String> back = new Stack<>();
		Stack<String> front = new Stack<>();
		
		while(true) {
			System.out.println("1 : 새로운 작업");
			System.out.println("2 : 실행 취소(Ctrl + z)");
			System.out.println("3 : feedback(Ctrl + y");
			System.out.println("0 : 종료");
			
			int N = sc.nextInt();
			
			if(N == 1) {
				// 1. 현재 진행 작업을 CtrlZ 스택에 추가한다.
				// 2. 새로운 작업을 입력받는다.
				// 3. CtrlY 스택을 비운다.
			}else if(N == 2) {
				// CtrlZ stack data를 CtrlY stack 에 저장
			}else if(N == 3) {
				// CtrlY Stack에서 pop CtrlZ Stack 으로 push
			}else {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		
		sc.close();
	}
}
