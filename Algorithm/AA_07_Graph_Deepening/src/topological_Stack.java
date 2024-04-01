import java.util.Scanner;
import java.util.Stack;

public class topological_Stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static int V, E;
	static int[][] adj;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack; // 탐색할 node를 담을 stack

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt(); // vertex 수
		E = sc.nextInt(); // edge 수

		adj = new int[V + 1][V + 1]; // vertex 번호 1부터 시작
		degree = new int[V + 1]; // 진입차수 저장
		visited = new boolean[V + 1];
		stack = new Stack<>();

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이니 반대는 처리할 필요 X
			// 진입차수 증가
			degree[B]++;
		} // 입력

		for (int i = 1; i < V + 1; i++) {
			// 진입차수가 0인 vertex 전부 DFS 탐색 실시
			if (degree[i] == 0) {
				DFS(i);
			}
		}
		
		// 위상정렬 끝 => Stack에 모두 존재
		while(!stack.isEmpty()) {
			System.out.println(cook[stack.pop()]);
		}
	}

	static void DFS(int v) {
		visited[v] = true;

		for (int i = 1; i < V + 1; i++) {
			// 인접하고, 방문하지 않은 점이 있다면 방문
			if (adj[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}

		// 모든 node를 탐색한 경우
		stack.add(v); // 출발지점까지 넣어준다.

	}

	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7\r\n" + "";

}
