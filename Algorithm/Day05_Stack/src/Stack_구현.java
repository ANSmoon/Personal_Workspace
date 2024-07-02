import java.util.Stack;

public class Stack_구현 {
	static int[] stack = new int[5];
	static int top = -1;

	public static void main(String[] args) {
		push(1);
		int data = pop();
		int data1 = pop();
		System.out.println(data);
		Stack<Integer> intStack = new Stack<>();
		intStack.push(1);
		int x = intStack.pop();
		System.out.println(x);
	}
	
	
	// stack 비었는지 확인 : isEmpty
	public static boolean isEmpty() {
		return top == -1;
	}
	
	// stack이 차있는지 확인 : isFull
	public static boolean isFull() {
		return top == stack.length - 1;
	}
	
	public static void push(int data) {
		if(isFull()) {
			System.out.println("그 그만해...");
			return;
		}
		stack[++top] = data;
	}

	public static int pop() {
		if(isEmpty()) {
			System.out.println("텅텅 구리");
			return -1;
		}
		return stack[top--];
	}
}
