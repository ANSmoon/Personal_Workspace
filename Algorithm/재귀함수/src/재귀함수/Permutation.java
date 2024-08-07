package 재귀함수;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	public static int N, M;
	public static int[] numbers;
	public static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		System.out.println(N + " , " + M);

		numbers = new int[M];
		visited = new int[N + 1];

		selectNum(0);

		sc.close();
	}

	public static void selectNum(int count) {

		// 재귀 함수의 탈출조건
		if (count == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i < 6; i++) {
			if (visited[i] == 0) {
				numbers[count] = i;
				visited[i] = 1;
				selectNum(count + 1);
				//해당 case 원상복구
				//numbers가 중복되지 않게
				visited[i] = 0;
			}
		}

	}
}
