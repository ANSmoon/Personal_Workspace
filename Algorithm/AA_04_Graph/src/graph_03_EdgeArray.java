import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graph_03_EdgeArray {
	static class Edge {
		int A, B;

		public Edge(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		Edge[] edges = new Edge[E]; // 객체 배열 형태
		List<Edge> edges2 = new ArrayList<>(); // List로 만들기

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			edges[i] = new Edge(A, B);
		}

		// 객체 대신 다른 방식
		int[][] edges3 = new int[E][2]; // [i][0] : 시작 vertex, [i][1] : 끝 정점
	}
}