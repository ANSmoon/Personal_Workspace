/*
 * Author : 문범수
 * Date : 2024-03-04
 * subject : 
 * main : 반복문 사용
 * issue : 배열 선언시 연달아 넣어주면 같은 주소를 참조한다.
 * name : .java
 * duration : 60m
 * CodeNo : 4047
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cardGame {
	static String str;
	static int[] s, d, h, c;
	static int ten, one, need_s, need_d, need_h, need_c;
	static char sep;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			str = reader.readLine();
			s = new int[14];
			d = new int[14];
			h = new int[14];
			c = new int[14];
			
			need_s = need_d = need_h = need_c = ans = 0;
			for (int i = 0; i < str.length(); i += 3) {
				sep = str.charAt(i);
				ten = (str.charAt(i + 1) - '0') * 10;
				one = str.charAt(i + 2) - '0';
				
				if (sep == 'S') {
					s[ten + one] += 1;
					continue;
				} else if (sep == 'D') {
					d[ten + one] += 1;
					continue;
				} else if (sep == 'H') {
					h[ten + one] += 1;
					continue;
				} else {
					c[ten + one] += 1;
					continue;
				}
			}
			
			for (int i = 1; i < 14; i++) {
				if (s[i] > 1 || d[i] > 1 || h[i] > 1 || c[i] > 1) {
					ans = -1;
					break;
				}
				if (s[i] == 1) {
					need_s++;
				}
				if (d[i] == 1) {
					need_d++;
				}
				if (h[i] == 1) {
					need_h++;
				}
				if (c[i] == 1) {
					need_c++;
				}
			}
			if (ans == -1) {
				System.out.println("#" + index + " " + "ERROR");
			} else {
				System.out.println("#" + index + " " + (13 - need_s) + " " + (13 - need_d) + " " + (13 - need_h) + " "
						+ (13 - need_c));
			}
			
			index++;
		}

	}
}
