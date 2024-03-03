/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 각 케이스별 비교가 가능한지
 * main : 문자열 비교
 * issue : 길이가 다른 경우 DIFF 출력 & 각 자리별로 구멍갯수 비교
 * name : glasses.java
 * duration : 20m
 * CodeNo : 7272
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class glasses {
	static String ans, none, one, two, str1, str2;
	static StringTokenizer token;
	static int[] arr1, arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		none = "CEFGHIJKLMNSTUVWXYZ";
		one = "ADOPQR";
		two = "B";

		while (index <= total) {
			ans = "DIFF";
			token = new StringTokenizer(reader.readLine());
			str1 = token.nextToken();
			str2 = token.nextToken();
			arr1 = new int[str1.length()];
			arr2 = new int[str2.length()];
			
			if (str1.length() == str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					// B랑 비교
					if (str1.charAt(i) == two.charAt(0)) {
						arr1[i] = 2;
					}
					// 구멍이 1개인 문자 비교
					for (int j = 0; j < one.length(); j++) {
						if (str1.charAt(i) == one.charAt(j)) {
							arr1[i] = 1;
							break;
						}
					}
				}
				
				for (int i = 0; i < str2.length(); i++) {
					if (str2.charAt(i) == two.charAt(0)) {
						arr2[i] = 2;
					}
					for (int j = 0; j < one.length(); j++) {
						if (str2.charAt(i) == one.charAt(j)) {
							arr2[i] = 1;
							break;
						}
					}
				}
			}
			
			if(Arrays.equals(arr1, arr2)) {
				ans = "SAME";
			}
			
			System.out.println("#" + index + " " + ans);
			index++;
		}
	}
}
