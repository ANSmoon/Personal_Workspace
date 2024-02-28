import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_Circuit {
	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = 20;

		queue.offer(new Person(sc.next(), 1));

		while (N > 0) {
			if (!queue.isEmpty()) {
				Person p = queue.poll();
				N -= p.count;
				if (N <= 0) {
					System.out.println(p.name + " Last pang");
				} else {
					System.out.println(p.name + "님이 " + p.count + "개 훔쳐감");
					p.count++;
					System.out.println("남은 갯수 : " + N + "개");
					queue.offer(p);
					queue.offer(new Person(sc.next(), 1));
				}
			}
		}
		sc.close();
	}
}

class Person {
	String name;
	int count;

	Person(String name, int count) {
		this.name = name;
		this.count = count;
	}
}