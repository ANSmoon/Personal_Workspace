import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class topological_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt(); // vertex 수
		int E = sc.nextInt(); // edge 수
		StringBuilder sb = new StringBuilder();

		int[][] adj = new int[V + 1][V + 1]; // vertex 번호 1부터 시작

		int[] degree = new int[V + 1]; // 진입차수 저장

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이니 반대는 처리할 필요 X
			// 진입차수 증가
			degree[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		// queue로 위상정렬 구현 1단계
		// 진입차수가 0인 vertex를 넣기

		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}

		// 2단계
		// queue가 공백상태가 될 때까지 수행
		while (!queue.isEmpty()) {
			// 2-1. 하나 꺼내기
			int curr = queue.poll();
			sb.append(cook[curr] + "\n");
			// 2-2. 연결되어 있는 간선 제거(실제로 제거하진 않는다.)
			for (int i = 0; i < V + 1; i++) {
				if (adj[curr][i] == 1) {
					degree[i]--; // 진입차수를 줄인다.
					adj[curr][i] = 0; // 실제 연결을 삭제해버림

					// 2-3. 진입차수가 0이 될 경우 queue에 삽입
					if (degree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		System.out.println(sb);
	}

	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7\r\n" + "";

}
