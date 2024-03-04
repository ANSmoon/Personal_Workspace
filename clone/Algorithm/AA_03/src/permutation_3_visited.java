import java.util.Arrays;

public class permutation_3_visited {
	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
	}
	
	// idx : 결과 배열에 저장할 위치
	public static void perm(int idx) {
		if(idx >= N) { // 다 뽑은 경우
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// N개의 원소를 가지고 판단 하려고
		for(int i = 0; i < N; i++) {
			// 사용했다는 표시
			if(visited[i]) {
				continue;
			}
			
			// 사용 안했을 경우 아래 코드가 실행
			result[idx] = nums[i];
			visited[i] = true; // 사용 완료
			perm(idx + 1);
			visited[i] = false; // 다시 사용가능하도록 설정
			// 원상복구를 사용하지 않는 이유는 값을 덮어버리기 때문에
		}
	}
}
