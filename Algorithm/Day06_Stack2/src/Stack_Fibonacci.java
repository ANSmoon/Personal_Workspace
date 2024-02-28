
public class Stack_Fibonacci {
	static long[] memoization = new long[100];
	public static void main(String[] args) {
		System.out.println(fibo(50));
		
	}
	public static long fibo(int n) {
		if(n <= 1) return n;
		if(memoization[n] != 0) return memoization[n];
		
		memoization[n] = fibo(n-1) + fibo(n-2);
		return memoization[n];
	}
}
