import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;

	Person() {
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age) {
			return this.name.compareTo(o.name);
		}else {
			return this.age - o.age; // 나이순 정렬	
		}
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class PriorityQueue_practice {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b){
				return b - a; // 양수, 0, 음수
//				if(a > b) {
//					return 1; // swap
//				}else if(a.equals(b)) {
//					return 0; // 같은 값 판단
//				}
//				return -1; // stay
			}
		});
		
		// priorityQueue : 기본 오름차순
		// 내림차순으로 바꾸고 싶다면 음수 사용
//		pq.add(-1);
//		pq.add(-2);
//		pq.add(-10);
//		pq.add(-5);
//		pq.add(-4);
//		pq.add(-3);
//		pq.offer(-73);
//		
//		System.out.println(-pq.poll());
//		System.out.println(-pq.poll());
//		System.out.println(-pq.poll());
//		System.out.println(-pq.poll());
//		System.out.println(-pq.poll());
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		
//		pq2.add(1);
//		pq2.add(2);
//		pq2.add(10);
//		pq2.add(5);
//		pq2.add(4);
//		pq2.add(3);
//		pq2.offer(73);
//		
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
		
		
		// Person은 비교 기준이 없기 때문에 예외 발생
		// 기준을 만들어 주기 위해
		// 1. Comparator를 PQ 생성자에 넣어준다(Lambda)
		// 2. 
		PriorityQueue<Person> pq3 = new PriorityQueue<>();
		
		pq3.add(new Person("대전 4반", 20));
		pq3.add(new Person("대전 5반", 20));
		pq3.add(new Person("대전 6반", 20));
		pq3.add(new Person("대전 7반", 20));
		
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
	}
}
