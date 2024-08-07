/*
 * Author : 문범수
 * Date : 2024-02-28
 * subject : recursive_function
 * main : 재귀함수 구현
 * issue : 효율적인 재귀함수 구현 logic 설정
 * name : exponential.java
 * duration : 20m
 * CodeNo : 1217
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exponential {
	public static int index;
	public static StringTokenizer token;
	public static int base, expon, result;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			index = Integer.parseInt(reader.readLine());
			token = new StringTokenizer(reader.readLine());
			base = Integer.parseInt(token.nextToken());
			expon = Integer.parseInt(token.nextToken());
			
			result = recursive_exponential(base, expon);
			System.out.println("#" + index + " " + result);
		}

	}

	public static int recursive_exponential(int base, int expon) {
		// base Line
		if(expon <= 1) {
			return base;
		}
		
		// recursive Line
		int temp = recursive_exponential(base, expon / 2);
		
		if(expon % 2 == 0) {
			return temp * temp;
		}
		return temp * temp * base;
	}
}
