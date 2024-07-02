import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskal {
	static class Edge implements Comparable<Edge>{
		int A, B, W;
		
		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}
	
	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // vertex 갯수(vertex 시작 번호)
		int E = sc.nextInt(); // edge 갯수

		// edge의 배열을 이용
		// 1. class 정의 or 2. 2차원 배열 이용

		int[][] edges = new int[E][3]; // [0] : 시작 vertex, [1] : 끝 vertex, [2] : 가중치

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		} // 간선 입력 끝

		// Kruskal 첫 번째 : 가중치 기준 정렬 필요(오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[2] - e2[2]; // 양수, 0, 음수 [가중치 기준]
			}
		});

		// class 이용 방식
//		Edge[] edges = new Edge[E];
//		
//		for(int i = 0; i < E; i++) {
//			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
//		} // edge 입력 끝
//		
//		Arrays.sort(edges);
//		
//		for(Edge e : edges) {
//			System.out.println(e);
//		}
		
		// 정렬 확인
//		for(int[] edge : edges) {
//			System.out.println(Arrays.toString(edge));
//		}

		// kruskal 두 번째 : V - 1개의 edge를 뽑아야한다. (Non Cycle)
		// 상호배타집합 활용
		p = new int[V];

		// make-set 실시(나 자신을 대표로 초기화)
		for (int i = 0; i < V; i++) {
//			makeset(i); // 정석
			p[i] = i; // skill
		}

		// V - 1 개의 간선을 뽑기 위함
		// while 문으로도 작성 해보기

		int ans = 0; // 최소비용의 합
		int pick = 0; // 내가 뽑은 edge 수

		for (int i = 0; i < E; i++) {
//			// i번째 edge를 뽑아 두 vertex의 대표를 확인
//			int x = edges[i][0];
//			int y = edges[i][1];
//
//			// 아래 if문의 의미 => x와 y대표가 다르다.
//			if (findset(x) != findset(y)) {
//				union(x, y);
//				ans += edges[i][2]; // 현재 edge를 선택한 것이니 가중치를 추가
//				pick++;
//			}

			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			// 아래의 문장이 있든 없든 답은 같다.
			if (pick == (V - 1)) {
				break;
			}
		} // edge 배열을 순회하는 for
		System.out.println(ans);
	}
	
	static void makeset(int x) {
		p[x] = x;
		// rank는 현재 하지 않는다.
	}

	static int findset(int x) {
		// 정석
//		if (x == p[x]) {
//			return x;
//		}
//		return findset(p[x]);

		// pass compression
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}

	private static void union(int x, int y) {
		// rank를 고려하지 않기 때문에 냅다 y 집합을 x의 집합으로 넣기
//		p[findset(y)] = findset(x);

		// 어차피 x, y는 대표만 넣어주기로 함
		p[y] = x;
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}