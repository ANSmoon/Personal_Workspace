import java.util.Arrays;

public class combination_2_recursive_iterate {
	static String[] material = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] set;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		set = new String[R];
		combination(0, 0);
	}

	private static void combination(int idx, int sidx) {
		// base case
		if (sidx == R) {
			System.out.println(Arrays.toString(set));
			return;
		}

		// recursive case
		for (int i = idx; i <= N - R + sidx; i++) {
			set[sidx] = material[i]; // 재료 뽑은 경우
			combination(i + 1, sidx + 1);
		}

	}
}
