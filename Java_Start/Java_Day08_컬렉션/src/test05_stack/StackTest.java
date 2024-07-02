package test05_stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
    	// Stack
    	// - LIFO
    	// - Stack Class
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i = 0; i < 5; i++) {
    		stack.push(i);
    	}
    	
    	// stack 에서 값을 순서대로 꺼내기
    	// - 가장 나중에 들어간 값이 가장 먼저 나온다.
    	while(!stack.isEmpty()) {
    		System.out.println(stack.pop());
    	}
    	
    }
}
