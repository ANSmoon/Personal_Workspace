package homework;

public class testing {
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0}, { 1, 2, 3} };
		System.out.println(tmp(arr,1));
	}
		static int tmp(int[][] arr, int row) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += arr[row][i];
			}
			return sum;
		}
}