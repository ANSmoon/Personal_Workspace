import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class prim_PrioirtyQueue {
	static final int INF = Integer.MAX_VALUE; // 큰 값으로 초기화

	public static class Edge implements Comparable<Edge> {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 0부터 시작
		int E = sc.nextInt(); //

		// adjacency matrix
		List<Edge>[] adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			// undriected graph
			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		} // input 끝

		// 방문처리를 위해 배열 선언
		boolean[] visited = new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		visited[0] = true; // 0번 vertex 시작~
		
		// 0번 vertex와 인접한 vertex 넣기
//		for(int i = 0; i < adjList[0].size(); i++) {
//			pq.add(adjList[0].get(i));
//		}
//		
//		for(Edge e : adjList[0]) {
//			pq.add(e);
//		}
		
		pq.addAll(adjList[0]);

		int pick = 1; // 현재 확보 vertex 갯수
		int ans = 0; // cost = 0
		
		while(pick != V) {
			Edge e = pq.poll();
			if(visited[e.ed]) continue; // 이미 해당 vertex가 방문한 점이라면
			// 2번 vertex => st, ed
			
			ans += e.w;
			visited[e.ed] = true;
			pick++;
			
			// 반복문 돌면서 갱신할 수 있는거 전부 갱신
			pq.addAll(adjList[e.ed]);
		}
		System.out.println(ans);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";

}
