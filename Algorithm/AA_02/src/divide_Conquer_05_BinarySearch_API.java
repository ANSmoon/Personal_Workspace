import java.util.Arrays;

public class divide_Conquer_05_BinarySearch_API {
	public static int[] arr;
	public static int key;

	public static void main(String[] args) {
		arr = new int[] { 2, 4, 6, 8, 9, 17, 28 };
		key = 7;
		
		// 해당 key에 맞는 index를 반환
		// 없는 key 탐색시 음수값 반환
		// 7 -> -4, 3 -> -2, 0 -> -1, 5 -> -3
		// 음수 반환에 어떠한 규칙이 존재한다.
		// key 보다 greater한 최초의 위치에서 -1을 곱하고 -1 실시
		System.out.println(Arrays.binarySearch(arr, 3));
	}
}
