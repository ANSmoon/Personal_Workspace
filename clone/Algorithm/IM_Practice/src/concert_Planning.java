/*
 * Author : 문범수
 * Date : 2024-03-03
 * subject : 
 * main : 문제 로직 설정
 * issue : 문제 이해 이슈 & index 오류
 * name : concert_Planning.java
 * duration : 40m
 * CodeNo : 4789
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class concert_Planning {
	static String st;
	static int ans;
	static int total;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= max) {
			st = reader.readLine();
			ans = 0;
			total = 0;

			for (int i = 0; i < st.length(); i++) {
				if (i == 0) {
					total += st.charAt(i) - '0';
					continue;
				} else if (st.charAt(i) - '0' == 0) {
					continue;
				}
				// 만약 지금 필요한 인원보다 더 필요한 경우
				else if (i > total) {
					ans += i - total;
					total += i - total + st.charAt(i) - '0';
				}
				else if(i <= total) {
					total += st.charAt(i) - '0';
				}
			}
			System.out.println("#" + index + " " + ans);
			index++;
		}

	}
}
