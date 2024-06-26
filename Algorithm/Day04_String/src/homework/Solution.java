/*
 * Author : 문범수
 * Date : 2024-02-01
 * subject : 회문 2
 * name : Solution.java
 * duration : 150m
 * CodeNo : 1216
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int index = 0;
		int result = 0;

		while (index <= 10) {
			index = Integer.parseInt(reader.readLine());
			char[][] ch = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = reader.readLine();
				for (int j = 0; j < 100; j++) {
					ch[i][j] = str.charAt(j);
				}
			}

			result = palindrome(ch);
			System.out.println("#" + index + " " + result);
			index++;
		}

		reader.close();
	}

	static int palindrome(char[][] ch) {
		int answer = 1;
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		int max4 = 0;

		// 열 먼저 탐색
		for (int i = 0; i < 100; i++) {
			for (int j = 1; j < 99; j++) {
				StringBuilder str1 = new StringBuilder();
				StringBuilder str2 = new StringBuilder();
				// 가운데를 기준으로 양쪽으로 뻗어 나가면서 같은게 있는지 탐색
				for (int k = 1; k < Math.min(j, 100 - j); k++) {
					str1.append(ch[i][j + k]);
					str2.append(ch[i][j - k]);
					if (str1.toString().equals(str2.toString())) {
						answer = (k * 2) + 1;
					} else {
						break;
					}
					max1 = Math.max(max1, answer);
				}
				answer = 0;
			}
			//양쪽으로 동시에 뻗어 나감
			for (int j = 0; j < 99; j++) {
				StringBuilder str3 = new StringBuilder();
				StringBuilder str4 = new StringBuilder();

				for (int k = 0; k <= Math.min(j, 99 - j - 1); k++) {
					str3.append(ch[i][j - k]);
					str4.append(ch[i][j + 1 + k]);
					if (str3.toString().equals(str4.toString())) {
						answer = str3.length()*2;
					} else {
						break;
					}
					max2 = Math.max(max2, answer);
				}
				answer = 0;
			}
		}
		
		//행 탐색
		for (int i = 0; i < 100; i++) {
			for (int j = 1; j < 99; j++) {
				StringBuilder str1 = new StringBuilder();
				StringBuilder str2 = new StringBuilder();
				// 가운데를 기준으로 양쪽으로 뻗어 나가면서 같은게 있는지 탐색
				for (int k = 1; k < Math.min(j, 100 - j); k++) {
					str1.append(ch[j + k][i]);
					str2.append(ch[j - k][i]);
					if (str1.toString().equals(str2.toString())) {
						answer = (k * 2) + 1;
					} else {
						break;
					}
					max3 = Math.max(max3, answer);
				}
				answer = 0;
			}
			//양쪽으로 동시에 뻗어 나감
			for (int j = 1; j < 99; j++) {
				StringBuilder str3 = new StringBuilder();
				StringBuilder str4 = new StringBuilder();

				for (int k = 0; k <= Math.min(j, 99 - j - 1); k++) {
					str3.append(ch[j - k][i]);
					str4.append(ch[j + 1 + k][i]);
					if (str3.toString().equals(str4.toString())) {
						answer = str3.length()*2;
					} else {
						break;
					}
					max4 = Math.max(max4, answer);
				}
				answer = 0;
			}
		}
		int[] maxarr = new int[4];
		maxarr[0] = max1;
		maxarr[1] = max2;
		maxarr[2] = max3;
		maxarr[3] = max4;
		
		Arrays.sort(maxarr);
		
		answer = maxarr[3];

		return answer;
	}
}
