public class powerSet_2_RecursionFunction {
	public static String[] material = {"단무지","참치","햄","소고기"};
	public static int N; // 재료 개수
	public static boolean[] set; // 재료 사용 유무
	
	public static void main(String[] args) {
		N = 4;
		set = new boolean[N];
		
		powerset(0);
	}

	// idx =해당 재료 인덱스                            
	
	public static void powerset(int idx) {
		// base case : 재귀를 빠져나갈 조건
		if(idx >= N) {
			String tmp = "";
			for(int i = 0; i < N; i++) {
				if(set[i]) {
					tmp += material[i];
				}
			}
			System.out.println(tmp);
			return;
		}
		
		// recursive case : 나 자신을 다시 호출하는 부분
		
		// 이번 재료 넣는 경우
		set[idx] = true;
		powerset(idx + 1); // -> 다음 재료를 판단
		
		
		// 이번 재료 안넣는 경우
		set[idx] = false; // 다음 코드부터 idx 가 1 큰 상태로 넣어지기 때문에
							// 제외해야 하는 재료는 true가 될 수 없다.
		powerset(idx + 1); // -> 다음 재료를 판단
	}
}
