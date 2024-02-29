package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cardGame {
	static StringTokenizer token;
	static int[] arr = new int[9]; // 가지고 있는 카드 배치
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		while(index <= total) {
			token = new StringTokenizer(reader.readLine());
			for(int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			win = 0; // 메인문 밖에서 확인해볼 것
			lose = 0; // 메인문 밖에서 확인해볼 것
			dfs(0);
			
			System.out.println("#" + index + " " + win + " " + lose);
			index++;
		}
		
	}
	
	// depth : 현재 위치
	public static void dfs(int depth) {
		// base line
		if(depth >= 8) {
			return;
		}
		
		
		// recursive line
		for(int i = 0; i < 18; i++) {
			// 현재 가지고 있는 카드는 넘어갈 것
			if(arr[depth] == i + 1) {
				continue;
			}
			
			// 1번카드부터 9번카드까지 돌면서 비교
			if(arr[depth] > i + 1) {
				win++;
			}
			else if(arr[depth] < i + 1) {
				lose++;
			}
			dfs(depth + 1);
		}
		return;
	}
}
