import java.util.Arrays;

public class Array06_Sector_Sub {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = 0;
		int N = 5;
		int M = 9;
		
		// 1. 전형적인 반복문 사용
		
		for (int i = N; i <= M; i++)
			sum += arr[i];

		System.out.println(sum);

		// 2. A : 0~M까지 합
		// B : 0~(N-1)까지 합
		// A - B : N ~ M 까지 합

		int A = 0;
		int B = 0;

		for (int i = 0; i <= M; i++)
			A += arr[i];

		for (int i = 0; i < N; i++)
			B += arr[i];
		
		System.out.println(A - B);
		
		// 3. prefixSum 사용
		// 이미 구해져 있는 값 사용
		
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for(int i = 1; i < arr.length; i++) 
			prefixSum[i] = prefixSum[i-1] + arr[i];
		System.out.println(Arrays.toString(prefixSum));
		
		// N >= 1 일때만 가능
		// System.out.println(prefixSum[M] - prefixSum[N-1]);
		
		int A1 = 0;
		int B1 = 0;
		
		for(int i = 0; i <= M; i++) {
			
		}
		
		
		
		
	}
}
