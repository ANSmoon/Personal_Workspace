/*
 * Author : 문범수
 * Date : 2024-02-16
 * subject : 
 * main : 
 * issue : 
 * name : flag.java
 * duration : m
 * CodeNo : 4613
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class flag {
	static int cnt; // 해당 색깔 갯수 담기
	static String str; // 문자열 받기
	static boolean b; // blue가 칠해져 있는지 확인
	static boolean r; // blue가 칠해져 있는지 확인
	static int comp;
	static int N;
	static int M;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			int sum = 0; // 총 반환 갯수
			String temp;
			
			// 첫번째 라인 -> 흰색 라인
			sum += change(reader.readLine(), 'W');
			
			for(int i = 1; i < N - 1; i++) {
				// 빨강이 온다면 뒤 모든 색깔은 빨강이 된다.
				temp = reader.readLine();
				if(b == false) {// 파랑이 오기전 빨강은 나오지 못한다.
					comp = change(temp, 'W') - change(temp, 'B');
					if(comp <= 0) {
						sum += change(temp,'W');
					}else {
						sum += change(temp, 'B');
						b = true;
					}
				}else if(i == N - 2 && b == false) { // 마지막 라인까지 블루가 없을 경우 블루로 색칠
					change(temp, 'B');
					b = true;
				}else if(b == true) {// 파랑이 온다면 하양은 나오지 못한다.
					comp = change(temp, 'B') - change(temp, 'R');
					if(comp <= 0) {
						sum += change(temp,'B');
					}else {
						sum += change(temp, 'R');
						r = true;
					}
				}else if(r == true) { // 빨강이 왔다면 계속 빨강만 합한다.
					sum += change(temp, 'R');
				}
			}
			// 마지막 라인 -> 빨강색 라인
			sum += change(reader.readLine(), 'R');
			// 가운데 부분만 파랑이 최소 1줄 들어가면서 최솟값 탐색
			
			System.out.println("#" + index + " " + sum);
			index++;
		}
	}
	// 모든 경우의 수를 돌고 배열이 올바른 녀석만 추출
	// 흰 -> 파 -> 빨
	
	// 파랑의 위치를 찾을 수 있다면?
	// 위쪽은 파랑과 하양의 비교
	// 아래쪽은 파랑과 빨강의 비교
	
	// 메소드 -> 인자로 문자열과 특정 문자를 받아 해당 문자와 다른 문자 갯수 반환
	static int change(String str, char x) {
		cnt = 0;
		for(int i = 0; i < M; i++) {
			if(str.charAt(i) == 'x') {
				cnt++;
			}
		}
		return str.length() - cnt;
	}
}
