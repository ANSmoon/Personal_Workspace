/*
 * Author : 문범수
 * Date : 2024-02-01
 * subject : 회문 1
 * name : 특정_문자열_탐색.java
 * duration : m
 * CodeNo : 1213
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 특정_문자열_탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int index = 0;
		while (index <= 10) {
			index = Integer.parseInt(reader.readLine());
			String search = reader.readLine();
			String origin = reader.readLine();
			int result = palindrome(origin, search);
			System.out.println("#" + index + " " + result);
			index++;
		}
		reader.close();
	}

	static int palindrome(String origin, String search) {
		int result = 0;
		
		
		
		return result;
	}
}
