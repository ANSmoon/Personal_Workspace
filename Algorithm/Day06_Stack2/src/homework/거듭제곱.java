/*
 * Author : 문범수
 * Date : 2024-02-06
 * subject : 사다리 경로 추적
 * main : 
 * name : 거듭제곱.java
 * duration : 10m
 * CodeNo : 1217
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거듭제곱 {
	public static void main(String[] args) throws Exception{
		//입력 index 및 reader 생성자 선언
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		while(index <= 10) {
			index = Integer.parseInt(reader.readLine());
			String str = reader.readLine();
			char x = str.charAt(0);
			char y = str.charAt(2);
			int n = x - '0';
			int m = y - '0';
			System.out.println("#" + index + " " + sqr(n,m));
			index++;
		}
		reader.close();
	}
	public static int sqr(int n, int m) {
		if(m <= 1) return n;
		return n * sqr(n, m - 1); 
	}
}
