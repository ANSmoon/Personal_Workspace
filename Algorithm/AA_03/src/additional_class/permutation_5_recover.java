package additional_class;

import java.util.Arrays;

public class permutation_5_recover {
	public static int[] nums, result;
	public static int N, M;

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3, 4, 5 };
		N = nums.length;
		M = 3;
		result = new int[M];

		permutation(0);

	}

	private static void permutation(int depth) {
		if(depth >= M) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[depth] = nums[i];
			permutation(depth + 1);
		}
		return;
	}
}
