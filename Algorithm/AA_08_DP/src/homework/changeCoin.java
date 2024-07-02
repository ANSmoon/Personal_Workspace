/*
 * Author : 문범수
 * Date : 2024-04-05
 * subject : 
 * main : DP
 * issue : DP처럼 풀었는지 의문
 * name : changeCoin.java
 * duration : 12m
 * CodeNo : 1970
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class changeCoin {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		for(int index = 1; index <= total; index++) {
			int N = Integer.parseInt(reader.readLine());
			int[][] change = new int[2][8]; // 총 8개의 돈의 종류, 내림차순, 그 아래행에는 count 배열 선언
			
			// 각 배열에 돈의 종류 입력
			change[0][0] = 50000;
			change[0][1] = 10000;
			change[0][2] = 5000;
			change[0][3] = 1000;
			change[0][4] = 500;
			change[0][5] = 100;
			change[0][6] = 50;
			change[0][7] = 10;
			
			int quotient;
			
			for(int i = 0; i < 8; i++) {
				quotient = N / change[0][i];
				if(quotient > 0) {
					change[1][i] = quotient;
					N -= quotient * change[0][i]; // 해당 금액으로 낼 수 있는경우 나머지를 이용해 빼준다.
				}
			}
			
			System.out.println("#" + index);
			for(int i = 0; i < 8; i++) {
				System.out.print(change[1][i] + " ");
			}
			System.out.println();
		}

	}
}
