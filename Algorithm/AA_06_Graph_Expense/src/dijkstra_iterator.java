import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dijkstra_iterator {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

	}

	static final int INF = 987654321;
	static int V, E;
	static List<Node>[] adjList; // adjacency list
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		} // 초기화 완료

		dist = new int[V];

		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			// 시작 vertex, 도착 vertex, 가중치 순으로 입력 完
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V]; // 방문 처리

		dist[start] = 0; // 시작 node까지의 거리는 0으로 초기화

		// 모든 vertex를 다 돌때까지 해보려 한다. (문제를 보고 도착vertex가 주어졌을때, 거기 방문할 시 stop)
		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			} // idx : 방문하지 않았으면서, 시작 vertex로부터 해당 idx vertex 까지의 거리가 최소인 vertex 선정
			
			// 시작 vertex로 부터 갈 수 있는 vertex는 모두 방문완료
			if(idx == -1) break;
			
			visited[idx] = true; // 선언

			// 아래 방법이 더 깔끔하다.
			for(Node node : adjList[idx]) {
				if(!visited[node.v] && dist[node.v] > dist[idx] + node.w) {
					dist[node.v] = dist[idx] + node.w;
				}
			}
		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "\r\n" + "";

}
