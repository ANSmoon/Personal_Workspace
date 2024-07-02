/*
 * Author : 문범수
 * Date : 2024-02-07
 * subject : 1씩 감소시키면서 암호 해독 => skip 과정 구현(심화)
 * main : Circular Queue 구현
 * name : cipherGenerator.java
 * duration : 1day
 * CodeNo : 1225
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cipherGenerator {
	// 전역변수 선언
	static int[] queue = new int[9]; // 이론상 재활용 가능
	static int[] result = new int[queue.length - 1];
	static int front = 0;
	static int rear = 0;
	static int index;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			index = Integer.parseInt(reader.readLine());
			StringTokenizer token = new StringTokenizer(reader.readLine());
			while (token.hasMoreTokens()) { // 입력받은 숫자들 queue에 삽입
				enQueue(Integer.parseInt(token.nextToken()));
			}
			decrease();
			queuePrint(result);
		} while (index < 10);
		reader.close();
	}

	// 1. enQueue 구현
	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("그 만 좀 넣 어 라");
			return;
		} else {
			rear = (rear + 1) % queue.length;
			queue[rear] = item;
			// queue[(rear++ % queue.legnth)] = item; => moduler 연산이 저장되지 않기 때문에
			// 의미 없음
		}
	}

	// 2. deQueue 구현
	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("아무도 없어요");
			return -1;
		} else {
			front = (front + 1) % queue.length;
			return queue[front];
		}
	}

	// 3. 순회 구현
	public static void decrease() {
		boolean turn = true;
		int temp = 0;
		// 조건에 맞을 때까지 cycle을 돈다.
		while (turn) {
			for (int i = 1; i < 6; i++) {
				temp = deQueue();
				if (temp - i <= 0) { // cycle 종료 조건
					enQueue(0);
					turn = false;
					break;	// 꼭 빠져나와야 한다!!!
				} else
					enQueue(temp - i);
			}
		}
	}

	// 4. 출력 구현
	public static void queuePrint(int[] result) {
		// #1 1 2 3 4 형식
		// front 다음 data부터 rear 까지 출력
		for (int i = 0; i < queue.length - 1; i++) {
			front = (front + 1) % queue.length;
			result[i] = queue[front];
		}
		System.out.print("#" + index + " ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	// 5. IsEmpty 구현
	public static boolean isEmpty() {
		if (front == rear)
			return true;
		return false;
	}

	// 6. IsFull 구현
	public static boolean isFull() {
		if ((rear + 1) % queue.length == front)
			return true;
		return false;
	}
}
