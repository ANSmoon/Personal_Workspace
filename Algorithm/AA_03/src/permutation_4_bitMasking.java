import java.util.Arrays;

public class permutation_4_bitMasking {
	static int[] nums;
	static int N;
	static int[] result;
	static int[] visited;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new int[N];

		result = new int[N];
		perm(0, 0);
	}

	// idx : 결과 배열에 저장할 위치
	// visited : 사용할 원소를 기록하기 위한 정수
	public static void perm(int idx, int visited) {
//		if(visited == (1<<N) - 1) return;
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}

		// 모든 원소를 돌면서 판단
		for (int i = 0; i < N; i++) {
			// 어떤 자리의 bit를 사용했는지 check가 필요함
			if ((visited & (1 << i)) != 0) {
				continue;
			}

			result[idx] = nums[i];
			perm(idx + 1, visited | (1 << i)); // bit로 체크표시를 동시에 수행하면서 dfs 실행
		}
	}
}