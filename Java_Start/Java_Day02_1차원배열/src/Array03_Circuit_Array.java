import java.util.Arrays;

public class Array03_Circuit_Array {
	public static void main(String[] args) {
		int[] nums = {13, 56, 1, 159, 200};
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
			
		}
		
		for(int num: nums) {
			System.out.println(num);
			num *= 2;
		}
		
		for(int num: nums) {
			System.out.println(num);	
		}
		
		System.out.println(nums);
		System.out.println(Arrays.toString(nums));
	}
}
