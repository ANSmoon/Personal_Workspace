import java.util.Arrays;

public class Queue_구현 {
	// 이렇게 저장 공간 및 선언하는 것 : createQueue
	static int[] queue = new int[10];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			enQueue(100);
		}
		int peek = Qpeek();
		System.out.println(Arrays.toString(queue));
	}
	
	// 포화상태 확인, 공백 확인, 삽입, 삭제
	// 삽입 때 실패여부 확인 위해 boolean 타입 반환 가능
	public static boolean isFull() {
		// data가 추가로 들어갈 수 있는지 확인
		return (rear == queue.length - 1);
	}
	
	public static boolean isEmpty() {
		return rear == front;
	}
	
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("그 그만");
			return;
		}
		queue[++rear] = data;
	}
	
	public static int deQueue() {
		if(isEmpty()) return -1;
		return queue[front++];
	}
	
	public static int Qpeek() {
		if(isEmpty()) {
			System.out.println("텅텅구리");
			return -1;
		}
		return queue[front+1];
	}
}
