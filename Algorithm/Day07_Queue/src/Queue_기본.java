import java.util.LinkedList;
import java.util.Queue;

public class Queue_기본 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
//		// 삽입
//		queue.add(1); // 예외 발생
//		queue.offer(2); // false 반환
//		
//		// 삭제
//		queue.remove(); // 예외 발생
//		queue.poll(); // null 반환
//		
//		// 조회
//		queue.element(); // 예외 발생
//		queue.peek(); // null 반환
		
		queue.offer(1);
		queue.offer(2);
		
		System.out.println(queue.peek());
		
	}
}
