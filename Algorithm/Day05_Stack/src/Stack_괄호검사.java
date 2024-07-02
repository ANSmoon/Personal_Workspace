import java.util.Stack;

public class Stack_괄호검사 {
	public static void main(String[] args) {
		// 소괄호만 있는 경우
		String str = "()()((()))";
		
		Stack<Character> stack = new Stack<>();
		boolean check = true;
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			
			if(x == '(') {
				stack.add(x);
			}else {
				if(stack.isEmpty()) {
					System.out.println("닫는 괄호 多");
					check = false;
					break;
				}
				stack.pop();
			}
		}
		
		// 다 끝난 후 stack이 비어있는지 확인
		if(check) {
			if(stack.isEmpty()) {
				System.out.println("짝임");
			}else {
				System.out.println("여는 괄호 多");
			}	
		}
	}
}
