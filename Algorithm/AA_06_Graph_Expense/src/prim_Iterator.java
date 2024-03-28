import java.util.Arrays;
import java.util.Scanner;

public class prim_Iterator {
	static final int INF = Integer.MAX_VALUE; // 큰 값으로 초기화

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 0부터 시작
		int E = sc.nextInt(); //

		// adjacency matrix
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			// undriected graph
			adjArr[A][B] = adjArr[B][A] = W;
		} // input 끝

		// 방문처리를 위해 배열 선언
		boolean[] visited = new boolean[V];
		int[] p = new int[V];
		int[] dist = new int[V]; // key라고 했던 가장 작은 비용을 저장하기 위한 배열

		// dist 초기화
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
			 p[i] = -1;
		}

//		Arrays.fill(dist, INF); // 이러한 방식도 가능

		// 임의의 한점을 선택해 돌린다.
		dist[0] = 0; // 0번 vertex부터 시행

		int ans = 0;
		// vertex 갯수인 v만큼 돌아도 상관 없음
		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			// 아직 안뽑힌 vertex 중 가장 작은 값을 뽑는다.
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // 해당 for문 종료시, idx : 가장 작은 값을 가지고 있고 방문하지 않은 vertex 선택됨
			visited[idx] = true; // 뽑은 경우
			for(int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
			
		} // vertex 선택 cycle
		
		for(int i = 0; i < V; i++) {
			ans += dist[i]; 
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(p));
		System.out.println(ans);
		
		
	}
	

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";

}
