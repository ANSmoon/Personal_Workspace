import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graph_02_adjacency_Graph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // vertex 갯수 (시작점이 0인지, 1인지 문제를 보고 결정)
		int E = sc.nextInt(); // edge 갯수

		List<Integer>[] adjList = new ArrayList[V]; // 인접리스트는 ArrayList 배열이다.

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		} // 초기화 작업

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			// 가중치를 함께 저장하기 위해선 사용자 정의 클래스 or int[] 형태로 삽입
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		// 인접 행렬 VS 인접 리스트
		
		// 1. 인접 행령 장단점
		// vertex 대비 edge가 너무 없다면 memory 낭비 발생
		// 두 Vertex가 인접한지 바로 check 가능
		
		// 2. 인접 리스트 장단점
		// 메모리 활용도 高
		// 두정점이 인접한지 확인을 위한 반복문 필요
		
		
		
		
		
		
	}
}