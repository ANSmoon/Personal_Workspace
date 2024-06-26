import java.util.Arrays;

public class selectionSort {
	public static void main(String[] args) {
		int[] nums = {123, 12, 52, 34, 24, 25};
		SelectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static int SelectionSort(int[] nums) {
		// 전체 cycle 반복문
		for(int i = 0; i < nums.length - 1; i++) {
			// 한 cycle에 대한 반복문
			// 정렬되지 않은 원소들 중 최솟값을 찾아서 swap
			
			int min_index = i;
			
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[min_index] > nums[j]) {
					min_index = j;
				}
			}
			
			int tmp = nums[i];
			nums[i] = nums[min_index];
			nums[min_index] = tmp;
		}
		
		
		return -1;
	}
}
