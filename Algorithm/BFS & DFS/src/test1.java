import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test1 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		
		int size = queue.size();
		for(int i = 0; i < size; i++) {
			System.out.println("queue값 : " + queue.poll() + " " + "크기 : " + queue.size());
		}
		
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		int size1 = list.size();
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list값 : " + list.get(i) + " " + "크기 : " + list.size());
		}
		
	}
}
