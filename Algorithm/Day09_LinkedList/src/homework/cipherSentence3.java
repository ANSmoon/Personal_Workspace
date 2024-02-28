package homework;

/*
 * Author : 문범수
 * Date : 2024-02-13
 * subject : Linked List
 * main : Doubly Linked List 구현
 * issue : 맨 처음 추가하는 과정에서 오류 발생
 * name : cipherSentence3.java
 * duration : 140m
 * CodeNo : 1230
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	String data = null;
	Node left = null;
	Node right = null;

	Node() {
	}

	Node(String data) {
		this.data = data;
	}
}

class DoublyLinkedList {
	Node head = null;
	Node tail = null;
	int length = 0;

	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.right = tail;
		tail.left = head;
	}

	// I(삽입) x, y, s : 앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입한다. s는 덧붙일 암호문들이다.[ ex) I 3 2
	// 123152 487651 ]
	void add(int index, String data) {
		if (index < 0 || index >= length) {
			System.out.println("그만해");
			return;
		}
		
		// 왜 right 인지 생각해볼것
		Node current = head.right; // 해당 node로 위치할 수 있도록 이동
		for (int i = 0; i < index; i++) {
			current = current.right;
		}
		Node newNode = new Node(data);

		newNode.right = current;
		newNode.left = current.left;

		current.left.right = newNode;
		current.left = newNode;
		length++;
	}

	// A(추가) y, s : 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다. [ ex) A 2 421257
	// 796813 ]
	// @overloading
	void add(String data) {
		Node newNode = new Node(data);

		if (length == 0) { // 첫 노드인 경우
			newNode.right = head;
			if(head != null) {
				head.left = newNode;
			}
			head = newNode;
			if(head.right == null) {
				tail = head;	
			}
			length++;
		}

		// newNode 연결
		newNode.right = tail;
		newNode.left = tail.left;
		
		// newNode 양쪽 방향 설정
		newNode.left.right = newNode;
		newNode.right.left = newNode;
		length++;
	}

	// D(삭제) x, y : 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.[ ex) D 4 4 ]
	void remove(int index, int number) {
		if (index < 0 || index >= length) {
			System.out.println("텅텅구리");
			return;
		}

		Node first = head.right;
		Node last = head.right;
		for (int i = 0; i < index; i++) {
			first = first.right;
			last = last.right;
		}

		for (int i = 0; i < number - 1; i++) {
			last = last.right;
		}

		first.left.right = last.right;
		last.right.left = first.left;
	}
	
	// 모든 data 조회
	void printList() {
		Node current = head.right;
		for(int i = 0; i < 10; i++) {
			System.out.print(current.data + " ");
			current = current.right;
		}
		System.out.println();
	}
}

public class cipherSentence3 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int index = 1;

		while (index < 11) {
			DoublyLinkedList list = new DoublyLinkedList();
			int N = Integer.parseInt(reader.readLine()); // 원본 암호 갯수 N
			String origin = reader.readLine(); // 원본 문자열 origin
			int M = Integer.parseInt(reader.readLine()); // 명령어 갯수 M
			String order = reader.readLine(); // 명령어 문자열

			StringTokenizer token = new StringTokenizer(origin); // 명령어 token화

			// original 문장 list 연결
			for (int i = 0; i < N; i++) {
				list.add(token.nextToken());
			}

			token = new StringTokenizer(order);
			// 명령어의 종류에 따라 조건문 구현
			while (token.hasMoreTokens()) {
				// 명령어 : 문자 / x : 숫자(위치) / y : 숫자(갯수) / s : 덧붙일 문자열
				int cnt = 0;
				String ordering = token.nextToken();
				cnt++;
				// I를 읽을 시 => x번째 암호문 바로 다음 y개 암호문 s를 덧붙임
				if (ordering.equals("I")) {
					int x = Integer.parseInt(token.nextToken());
					int y = Integer.parseInt(token.nextToken());

					for (int i = 0; i < y; i++) {
						list.add(x++, token.nextToken());
					}

					// D를 읽을 시 => x번째 암호문 바로 다음부터 y개 암호문 삭제
				} else if (ordering.equals("D")) {
					int x = Integer.parseInt(token.nextToken());
					int y = Integer.parseInt(token.nextToken());

					list.remove(x, y);

					// A를 읽을 시 => 맨 뒤에 y개의 암호문 s를 덧붙임
				} else {
					int y = Integer.parseInt(token.nextToken());
					for (int i = 0; i < y; i++) {
						list.add(token.nextToken());
					}
				}
				
				// 명령어 갯수 만큼 읽어 들일 시 break;
				if (cnt >= M)
					break;
			}

			System.out.print("#" + index + " ");
			list.printList();
			index++;
		}
			reader.close();

	}
}
