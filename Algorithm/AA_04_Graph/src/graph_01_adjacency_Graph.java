import java.util.Scanner;

public class graph_01_adjacency_Graph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // vertex 갯수 (시작점이 0인지, 1인지 문제를 보고 결정)
		int E = sc.nextInt(); // edge 갯수
		
		int[][] adjArr = new int[V][V]; // 위를 보고 V * V, (V + 1) * (V + 1) 결정
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt(); // 2개의 정점 입력 받기
			int B = sc.nextInt();
//			int W = sc.nextInt(); // 경우에 따라 weight를 입력받을 수 있음
			
			adjArr[A][B] = 1; // 가중치가 없을 때
			adjArr[B][A] = 1; // Undirected Graph일 때 사용
			
//			adjArr[A][B] = adjArr[B][A] = W; // 한줄로 작성 가능
		}
	}
}