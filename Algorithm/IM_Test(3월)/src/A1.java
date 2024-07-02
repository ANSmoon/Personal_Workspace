import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1 {
	static StringTokenizer token;
	static int N, M, ans, st_r, st_c, des_r, des_c;
	static int row, col;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int index = 1;

		while (index <= total) {
			ans = 0;
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
					if (arr[i][j] == 2) {
						st_c = j;
						st_r = i;
					}
					if (arr[i][j] == 3) {
						des_c = j;
						des_r = i;
					}
				}
			}

			// 도착지와 붙어있는 같은 행 번호들을 3으로 교체
			int tmp1 = des_c - 1;
			int tmp2 = des_c + 1;
			while (tmp1 >= 0) {
				if (arr[des_r][tmp1] == 1) {
					arr[des_r][tmp1--] = 3;
				} else {
					break;
				}
			}
			while (tmp2 < M) {
				if (arr[des_r][tmp2] == 1) {
					arr[des_r][tmp2++] = 3;
				} else {
					break;
				}
			}
			
			// 위 아래를 3으로 바꾸는 작업
			for (int i = 0; i < M; i++) {
				if (arr[des_r][i] == 3) {
					for (int j = 1; j < N; j++) {
						int up = des_r - j;
						int down = des_r + j;

						if (up >= 0 && arr[up][i] == 1 && (down >= N || arr[down][i] == 0)) {
							arr[up][i] = 3;
							ans = j;
							break;
						} else if (down < N && arr[down][i] == 1 && (up < 0 || arr[up][down] == 0)) {
							arr[down][i] = 3;
							ans = j;
							break;
						} else if (up >= 0 && down < N && arr[up][i] == 1 && arr[down][i] == 1) {
							arr[up][i] = 3;
							arr[down][i] = 3;
							ans = j;
							break;
						}
					}
				} else {
					continue;
				}
			}
			

			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("#" + index + " " + ans);
			index++;
		}
	}

	static void dfs() {
		// base line

		// recursive line

	}
}
