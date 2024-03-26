import java.util.Scanner;

public class BFS {
	static int V; // node 수
	static int[][] adj; // adjacency matrix
	static boolean[] visited; // 방문 check

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adj = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A][B] = adj[B][A] = 1; // adjacency matrix(Undirected)
		} // edge 정보 입력 완료
	}
	
	public static void DFS(int v) {
		visited[v] = true;
		System.out.println(v);
		
		// 인접한 node들 visit(adj matrix, adj list code 약간 상이)
		for(int i = 1; i <= V; i++) {
			if(!visited[i] && adj[v][i] == 1) {
				DFS(i);
			}
		}
		
		// adj list는 아래처럼 사용 가능
//		for(int i = 1; i <= V; i++) {
//			if(!visited[i]) {
//				DFS(i);
//			}
//		}
	}
	
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7\r\n"
			+ "";
}