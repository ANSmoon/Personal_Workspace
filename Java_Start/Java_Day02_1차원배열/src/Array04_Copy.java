import java.util.Arrays;

public class Array04_Copy {
	public static void main(String[] args) {
		int[] nums = {13, 56, 1, 159, 200};
		
		// 1. 반복문
		// - 새로 배열 생성 후 반복문을 통해 옮기기
		
		int[] temp = new int[nums.length * 2];
		
		for(int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}
		
		System.out.println(Arrays.toString(temp));
		
		// 2. Array.copyOf(원본배열, 새로운 배열 크기);
		
		int[] temp2 = Arrays.copyOf(nums,10);
		System.out.println(Arrays.toString(temp2));
		
		// 3. System.arraycopy(원본배열, 원본배열 시작점, 복사배열, 복사배열 시작점, 복하할 크기)
		
		int[] temp3 = new int[10];
		
		System.arraycopy(nums,0,temp3,0,nums.length);
		
		System.out.println(Arrays.toString(temp3));
		
		// Object : 객체의 참조형이 들어간다.
		// 모든 배열은 객체로 취급, 참조형
		// int[], boolean[], double[], String[]
		// 참조값이 넘어간다.
		
	}
}
