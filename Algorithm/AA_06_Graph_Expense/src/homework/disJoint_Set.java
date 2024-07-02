/*
 * Author : 문범수
 * Date : 2024-03-27
 * subject : union, find, make 의 기본적인 logic 이해
 * main : 정석 방식의 make, find, unionSet code
 * issue : 
 * name : disJoint_Set.java
 * duration : 30m
 * CodeNo : 3289
 */

package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class disJoint_Set {
	static int N, M, x, y, cal; // N 이하의 정수 입력, M개의 연산(합집합, 확인연산)
	static int[] p;
	static StringBuilder sb;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			p = new int[N + 1]; // n까지 부모노드를 저장할 배열 생성
			sb = new StringBuilder();

			// 새로운 집합 생성
			for (int i = 1; i <= N; i++) {
//				makeSet(i);
				p[i] = i; // Skill~
			}

			// M번의 연산 반복
			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(reader.readLine());
				cal = Integer.parseInt(token.nextToken());
				x = Integer.parseInt(token.nextToken());
				y = Integer.parseInt(token.nextToken());

//				p[x] = x;
//				p[y] = y;

				if (cal == 0) { // Union 진행
//					int py = findSet(y);
//					int px = findSet(x);
					unionSet(x, y);
				} else { // find 진행
					if (findSet(x) != findSet(y)) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
			}

			System.out.println("#" + index + " " + sb);
		}
	}

//	static void makeSet(int x) {
//		p[x] = x;
//	}

	static int findSet(int x) {
//		if (x == p[x]) {
//			return x;
//		}
//		return findSet(p[x]); // 함수 재귀 호출

		// path Compression
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x]; // return 하는 과정에서 연결된 부모를 최신화 한다.
	}

	// y의 집합을 x에 연결시킨다.
	static void unionSet(int x, int y) {
		p[findSet(y)] = findSet(x);

		// 만약 path Compression으로 했다면
//		p[y] = x; // 해당 대표만 넣어주면 되기 때문에 편하다.
	}
}