/*
 * Author : 문범수
 * Date : 2024-01-30
 * subject : Selection sort로 풀어보기
 * name : sol2.java
 * duration : 10m
 * CodeNo : 1208
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol2 {
	public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
		int ten = 1;
		
		// 입력 및 배열 정수형 전환
		// 한번에 입력 연습스
		while(ten <= 10) {
			String total = reader.readLine();
			String str = reader.readLine();
			
			StringTokenizer token = new StringTokenizer(str);
			int[] arr = new int[token.countTokens()];
			
			int index = 0;
			while(token.hasMoreTokens()) {
				arr[index++] = Integer.parseInt(token.nextToken());
			}
			
			// moving logic
			// 먼저 정렬 진행 => 0번째 행과 마지막번째 행 1씩 교환
			for(int k = 0; k < Integer.parseInt(total); k++) {
				ss(arr); // 선 정렬
				arr[0]++;
				arr[arr.length-1]--;
			}
			ss(arr); // 후 정렬
			System.out.printf("#%d %d\n",ten, arr[arr.length-1] - arr[0]);
			ten++;
		}
	}
	// 배열 정렬
	// selection sort
	public static void ss(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
