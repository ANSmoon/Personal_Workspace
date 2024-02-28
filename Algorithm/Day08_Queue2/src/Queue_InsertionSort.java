import java.util.Arrays;

public class Queue_InsertionSort {
	public static void main(String[] args) {
		int[] data = { 69, 10, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };

		// 정렬 되지 않은 집합(U)의 원소를 하나씩 순회
		for (int i = 0; i < data.length; i++) {
			int key = data[i];

			// 정렬된 집합(S)의 원소와 뒤에서부터 비교하면서 위치 탐색
			int j;
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}
			// 반복문 안에서 key가 들어갈 위치 찾음
			// j가 마지막에 한번 감소하기 때문에 다시 +1이 필요
			data[j + 1] = key;
		}
		System.out.println(Arrays.toString(data));
	}
}
