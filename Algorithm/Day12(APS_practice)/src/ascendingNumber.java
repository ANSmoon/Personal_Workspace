/*
 * Author : 문범수
 * Date : 2024-02-16
 * subject : 
 * main : 
 * issue : 
 * name : ascendingNumber.java
 * duration : m
 * CodeNo : 6190
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ascendingNumber {
	static StringTokenizer token;
	static int x;
	static int[] arr;
	static int[] mul;
	static int tmp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());
		int N = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			arr = new int[5*N];
			x = 0;
			while (token.hasMoreTokens()) {
				tmp = Integer.parseInt(token.nextToken());
				
				// 2자리수 이상의 숫자들 자릿수 별로 저장 하기
				if(tmp >= 10) {
					arr[x] = Stream.of(String.valueOf(tmp).split("")).mapToInt(Integer::parseInt).toArray();
				}else {
					arr[x++] = tmp;
				}
			}
			
			
			
			index++;
		}

	}
}
