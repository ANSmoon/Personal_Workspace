import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DFS {
	static int V; // node 수
	static List<Integer>[] adj; // adjacency list
	static boolean[] visited; // 방문 check

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		int E = sc.nextInt();
		visited = new boolean[V + 1];
		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A].add(B);
			adj[B].add(A);// adjacency list(Undirected)
		} // edge 정보 입력 완료

//		for(List list : adj) {
//			System.out.println(list);
//		}

		BFS(1);

	}

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(v); // 시작 node를 queue에 넣는다.
		visited[v] = true; // 시작 node를 방문처리

		// queue가 공백상태가 될 때까지 반복문 수행
		while (!queue.isEmpty()) {
			int curr = queue.poll(); // node 하나 꺼내기
			System.out.println(curr); // 경로 찍기

			// adj list
			for (int w : adj[curr]) {
				if (!visited[w]) {
					queue.add(w);
					visited[w] = true; // 미리 방문처리해서 queue에 중복으로 넣는 것을 방지
				}
			}
		}
	}

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "";
}