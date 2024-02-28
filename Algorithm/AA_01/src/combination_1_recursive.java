import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_1_recursive {
	// data array
	static String[] material = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] set;
	static List<String[]> list = new ArrayList<>();

	public static void main(String[] args) {
		N = 4;
		R = 2;
		set = new String[R];
		combination(0, 0);
	}

	// idx : 현재 내가 판단할 재료
	// sidx : 조합할 재료의 index
	private static void combination(int idx, int sidx) {
		// base case

		if (sidx == R) { // 다 뽑은 경우(햄버거 완성)
			String[] tmp = new String[R];
			for(int i = 0; i < R; i++) {
				tmp[i] = set[i];
			}
			
			System.out.println(Arrays.toString(set));
			list.add(set);
			return;
		}

		if (idx == N) { // 재료는 다 고려 했지만 안된경우 어쩔 수 없음
			return;
		}

		// recursive case
		// 재료 넣었음
		set[sidx] = material[idx];
		combination(idx + 1, sidx + 1); // 해당 idx번째 재료 sidx 위치에 존재
		combination(idx + 1, sidx); // 해당 idx번째 재료 sidx 위치에 없음

	}
}