package singly;

class Node {
	String data;
	Node left;
	Node right;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}
}

class DoublyList {
	Node head;
	Node tail;
	int size;

	DoublyList() {
		head = new Node();
		tail = new Node();
		head.right = tail;
		tail.left = head;
	}
	// 삽입
	

	// 마지막에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);
		
		// newNode 먼저 연결
		newNode.right = tail;
		newNode.left = tail.left;
		
		
		// newNode 양옆에 있는 node가 newNode를 가르키도록 바꿈
		newNode.right.left = newNode;
		newNode.left.right = newNode;
		size++;
	}

	// 삭제
	void remove(int index) {
		// index 범위 확인
		if(!(0 <= index && index < size)){
			System.out.println("Range over");
			return;
		}
		
		// 삭제할 node로 직접 이동 => singly node와 차이점
		// 시작 node를 head.next로 하기 때문에
		Node rmNode = head.right;
		for(int i = 0; i < index; i++) {
			rmNode = rmNode.right;
		}
		
		// 반복문이 끝나면 current는 삭제 node를 가르킴
		rmNode.left.right = rmNode.right;
		rmNode.right.left = rmNode.left;
		
		size--;
	}
	// 모든 data 조회
	void printList() {
		Node current = head.right;
		while(current != tail) {
			System.out.print(current.data + " -> ");
			current = current.right;
		}
		System.out.println();
	}
	
}



public class DoublyLinkedList {
	public static void main(String[] args) {
		DoublyList list = new DoublyList();
		list.addLast("1");
		list.addLast("2");
		list.addLast("3");
		list.addLast("4");
		
		list.printList();
		list.remove(1);
		list.printList();
	}
}
