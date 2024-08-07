import java.util.Arrays;

public class countingSort {
	public static void main(String[] args) {
		int[] nums = {123, 12, 52, 34, 24, 25};
		
		int[] sortedNums = countingSort(nums);
		System.out.println(Arrays.toString(sortedNums));
	}

	public static int[] countingSort(int[] nums) {
		int[] count = new int[200];
		
		// 원소들의 개수를 세어서 count 배열에 저장
		for(int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		
		// count 배열을 누적합배열로 저장
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		int[] sortedNums = new int[nums.length];
		
		// 역방향 순회로 누적합 배열을 보고 위치 탐색
		// index는 0부터 시작하기 때문에 count로 부터 얻은 누적합 값에서 -1 하고 시작
		for(int i = nums.length - 1; i >= 0; i--) {
			sortedNums[--count[nums[i]]] = nums[i];
		}
		
		return sortedNums;
		
	}
}
