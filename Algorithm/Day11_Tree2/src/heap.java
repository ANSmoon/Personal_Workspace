import java.util.Arrays;

public class heap {

	static int[] heap = new int[100];
	static int heapSize;
	
	public static void main(String[] args) {
		heapPush(10);
		heapPush(2);
		heapPush(5);
		heapPush(24);
		heapPush(8);
		
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(Arrays.toString(heap));
	}
	
	static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	
	// 삽입
	static void heapPush(int data) {
		
		// 마지막 위치에 node 추가
		heap[++heapSize] = data;
		
		// 부모와 비교하면서 swap
		int child = heapSize; // heapsize 위치에 존재
		int parent = heapSize / 2; // 부모 노드는 자식 노드의 index 절반
		
		while(parent > 0 && heap[parent] < heap[child]) { // 부모 노드가 자식 노드보다 작을경우
			// swap
			swap(parent, child);
			
			// index 또한 재조정
			child = parent;
			parent = child / 2;
		}
	}
	
	// 삭제
	static int heapPop() {
		// root 원소 제거
		int result = heap[1];
		
		// 마지막 원소 root로 옮기기
		heap[1] = heap[heapSize--];
		
		int parent = 1; // 부모노드
		int child = parent * 2; // 왼쪽 자식 노드
		
		if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child++;
		}
		
		// leaf 노드는 자식이 없을 수도 있으니 child가 heapSize 이하인지 확인
		while(child <= heapSize && heap[child] > heap[parent]) {
			// 자식이 더 크면 swap
			swap(parent, child);
			
			parent = child;
			child = parent * 2;
			// 만약 왼쪽보다 오른쪽이 더 크다면 child를 오른쪽으로 변경
			if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
				child++;
			}
		}
		return result;
	}
}
