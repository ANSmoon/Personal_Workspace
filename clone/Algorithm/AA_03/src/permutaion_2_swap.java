import java.util.Arrays;

public class permutaion_2_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		perm(0);
	}

	public static void perm(int idx) {
		// base case
		if (idx >= N) {
			System.out.println(Arrays.toString(nums));
			return;
		}

		// recursive case
		for (int i = idx; i < N; i++) {
			// (i, idx)의 위치를 swap
			swap(i, idx);
			perm(idx + 1);
			// (i, idx)의 위치를 swap(원상복구하는 과정)
			swap(i, idx);
		}

	}

	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
