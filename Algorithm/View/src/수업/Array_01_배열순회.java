package 수업;

import java.util.Arrays;

public class Array_01_배열순회 {
	public static void main(String[] args) {
//		int[] nums = new int[6];
//		
//		System.out.println(Arrays.toString(nums));
//		
//		nums[0] = 1;
//		nums[1] = 2;
//		nums[2] = 3;
//		nums[3] = 4;
//		nums[4] = 5;
//		nums[5] = 6;
//		
//		System.out.println(Arrays.toString(nums));
		
		// 2. 배열 선언과 동시에 초기화
		int[] arr = {1,2,3,4,5,6};
//		System.out.println(Arrays.toString(arr));
		
		// 3. 정방향 순회
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 4. 역방향 순회
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		
		
	}
}
