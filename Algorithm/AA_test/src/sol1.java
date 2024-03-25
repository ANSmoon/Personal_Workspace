/*
 * Author : 문범수
 * Problem : 자리를 사수하라
 * date : 2024 - 03 - 25
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class sol1 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int[][] matrix = new int[9][9];
		StringTokenizer token;
		int result = 0; // 앉은 사람의 수
		int M, D, S;

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			List<Integer[]> list = new ArrayList<>(); // 빈자리 list
			Stack<Integer[]> stack = new Stack<>();

			for (int i = 0; i < 9; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < 9; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					if (matrix[i][j] == 0 && i % 2 == 0) { // 짝수 행에서는 순차 탐색
						list.add(new Integer[] { i, j }); // 자리 배치
					} else if (matrix[i][j] == 0 && i % 2 == 1) {
						stack.add(new Integer[] { i, j });
					}
				}
				while (!stack.isEmpty()) {
					list.add(stack.pop());
				}
			}

			// list => 앉을 수 있는 자리

			// M : 견딜 수 있는 소음 크기
			// D : 소음이 들리는 거리
			// S : 자리에 앉았을 때 내는 소음 크기

			int wait = Integer.parseInt(reader.readLine());
			for (int i = 0; i < wait; i++) {
				token = new StringTokenizer(reader.readLine());
				M = Integer.parseInt(token.nextToken());
				D = Integer.parseInt(token.nextToken());
				S = Integer.parseInt(token.nextToken());
				
				boolean pass = check(M, D, S, matrix, list);
				if(pass) {
					result++;
				}
			}
			if (result == 0) {
				result = -1;
			}
			System.out.println("#" + index + " " + result);
			index++;
		}
	}

	// 해당 자리에 앉을 수 있는지 판단
	static boolean check(int M, int D, int S, int[][] matrix, List<Integer[]> list) {
		
		
		
		return true;
	}
}
