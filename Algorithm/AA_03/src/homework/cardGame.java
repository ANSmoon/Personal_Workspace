/*
 * Author : 문범수
 * Date : 2024-02-29
 * subject : DFS
 * main : BackTracking
 * issue : 전달하는 score의 점수가 이전 점수를 불러와야 하기 때문에 따로 저장해선 안된다.
 * name : cardGame.java
 * duration : 80m
 * CodeNo : 6808
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cardGame {
	static StringTokenizer token;
	static int[] arr = new int[9]; // 가지고 있는 카드 배치
	static int score1, score2; // 실험 대상
	static int win, lose;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			token = new StringTokenizer(reader.readLine());
			visited = new boolean[19];
			// 카드 받아오기
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
				visited[arr[i]] = true; // 가지고 있는 카드에 대해 방문 처리
			}
			dfs(0, 0, 0);

			System.out.println("#" + index + " " + win + " " + lose);
			win = 0;
			lose = 0;
			
			index++;
		}

	}

	// depth : 현재 위치
	public static void dfs(int depth, int score1, int score2) {
		// base line
		// 지금까지 더한 score1과 score2를 비교해 승부 판단
		if (depth == 9) {
			if(score1 > score2) {
				win++;
			}else if(score1 < score2) {
				lose++;
			}
			return;
		}

		// recursive line
		for (int i = 1; i <= 18; i++) {
			// 현재 가지고 있는 카드는 넘어갈 것
			if (visited[i]) {
				continue;
			}

			// 1번카드부터 9번카드까지 돌면서 비교
			if (arr[depth] > i) {
				visited[i] = true;
				// 전달하는 score의 점수가 이전 점수를 불러와야 하기 때문에 따로 저장해선 안된다.
				dfs(depth + 1, score1 + arr[depth] + i, score2);

			} else{
				visited[i] = true;
				// 전달하는 score의 점수가 이전 점수를 불러와야 하기 때문에 따로 저장해선 안된다.
				dfs(depth + 1, score1, score2 + arr[depth] + i);
			}
			visited[i] = false;
		}
		return;
	}
}
