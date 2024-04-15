import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2_대전_04반_문범수 {
	static int N, M, result;
	static int[][] matrix; // 각 지역별 거리 저장 배열
	static int[][] visited; // 해당 지점까지의 최소 거리 입력 배열
	static List<int[]> shelter; // 쉼터의 좌표 입력 queue
	static Queue<int[]> queue; // 현재 이동가능 좌표 입력 queue
	static StringTokenizer token;
	static int[] dr = { 0, 1, 0 }; // 행 이동 방향 [우, 하, 좌]
	static int[] dc = { 1, 0, -1 }; // 열 이동 방향 [우, 하, 좌]

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			shelter = new LinkedList<int[]>(); // queue 초기화
			queue = new LinkedList<int[]>(); // queue 초기화
			matrix = new int[N][N];
			visited = new int[N][N];

			// 각 위치별 이동거리 입력
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					visited[i][j] = matrix[i][j];
				}
			}

			// 쉼터의 x, y좌표를 shelter queue에 입력받는다.
			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(reader.readLine());
				shelter.add(new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) });
			}

			// 시작 지점 (0, 0) 입력 및 해당 위치까지의 거리 입력
			queue.offer(new int[] { 0, 0, matrix[0][0] });

			// 먼저 shelter까지의 최소거리를 탐색
			for (int i = 0; i < shelter.size(); i++) {
				int[] pos = shelter.get(i);
				int x = pos[0];
				int y = pos[1];
				
			}
			move();
			result = visited[N - 1][N - 1];
			System.out.println("#" + index + " " + result);
		}
	}

	static void move() {
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int distance = pos[2];

			// 3방향 탐색 진행
			for (int k = 0; k < 3; k++) {
				int row = x + dr[k];
				int col = y + dc[k];
				if(row == 0 && col == 0) {
					continue;
				}
				// 해당 위치가 범위안에 있으며
				if (row >= 0 && col >= 0 && row < N && col < N) {
					// 방문하려는 지역이 최초 탐색일때는 일단 들어간다.
					if (visited[row][col] == matrix[row][col]) {
						visited[row][col] += distance;
						queue.offer(new int[] { row, col, visited[row][col] });
					} else if (visited[row][col] > distance + matrix[row][col]) {
						visited[row][col] = distance + matrix[row][col];
						queue.offer(new int[] { row, col, visited[row][col] });
					}
				}
			}
		}
	}
}