import java.util.Arrays;

public class Queue_Circulation {
	static int front = 0;
	static int rear = 0;
	static String[] queue = new String[5];

	public static void main(String[] args) {
		System.out.println(Arrays.toString(queue));
		enQueue("Karina");
		enQueue("IU");
		enQueue("Wonyoung");
		enQueue("Chaewon");
		deQueue();
		enQueue("Suzy");
		System.out.println(Arrays.toString(queue));
		
		
		
	}

	// 공백상태
	// front == rear
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화상태
	// (front) == (rear + 1) % n
	public static boolean isFull() {
		return (front == (rear + 1) % queue.length);
	}
	
	// enQueue
	public static void enQueue(String data) {
		if(isFull()) {
			System.out.println("그 만 미 어 터 진 다.");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}
	
	// deQueue
	public static String deQueue() {
		if(isEmpty()) {
			System.out.println("텅 텅 구 리");
			return null;
		}
		front = (front + 1) % queue.length;
		return queue[front];
	}
}
