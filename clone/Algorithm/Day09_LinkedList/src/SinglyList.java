class Node {
	String data;
	Node link;

	Node() {
	};

	Node(String data) {
		this.data = data;
//		link = null;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	// 삽입
	// 제일 앞에 삽입
	void addFirst(String data) {
		Node newNode = new Node(data);

		// 순서가 중요
		// 기존 연결 끊기 전 newNode 먼저 연결
		newNode.link = head.link;
		head.link = newNode;
		size++;
	}

	// 중간 삽입
	void add(int index, String data) {
		if (index < 0 || size < index) {
			System.out.println("불가능한 위치");
			return;
		}

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.link;
		}
		// current가 삽입하고자 하는 위치 앞 node를 가르킴
		Node newNode = new Node(data);
		newNode.link = current.link;
		current.link = newNode;
		size++;
	}

	// 제일 뒤에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);

		Node current = head;
		while (current.link != null) {
			current = current.link;
		}
		// 반복문이 끝나면 current는 마지막 node를 가르킴

		current.link = newNode;
		// newNode가 마지막 node가 됨
		size++;
	}

	// 삭제
	// 지정한 index에 해당하는 node 삭제
	void remove(int index) {
		if (index < 0 || size <= index) {
			System.out.println("삭제 범위를 찾을 수 없음");
			return;
		}

		// singly List 는 시작 node가 head
		Node current = head;

		// 반복문이 끝나면 current는 삭제 node 앞을 가르킴
		for (int i = 0; i < index; i++) {
			current = current.link;
		}
		
		// 삭제될 node 뒤의 node를 가르킴
		current.link = current.link.link;
		size--;
	}

	// 조회
	
	
	// 모든 data 조회
	void printList() {
		Node current = head.link;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.link;
		}
		System.out.println();
	}

	int getSize() {
		Node current = head;
		int size = 0;
		while (current.link != null) {
			current = current.link;
			size++;
		}
		return size;
	}
}

public class SinglyList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.addFirst("IU");
		list.addLast("Wonyoung");
		list.addFirst("Karina");
		list.addLast("Minji");
		list.add(1, "Hanni");

		list.printList();

	}
}
