import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class security {
	static int[][] matrix;
	static int N, M, K, result;
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());

			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			// 손해를 보지 않고 많은 집에 서비스를 제공할 수 있는 최대 집의 갯수
			result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					result = Math.max(result, countMaxHouses(i, j));
				}
			}

			System.out.println("#" + index + " " + result);
		}

	}

	static int countMaxHouses(int x, int y) {
		int maxHouses = 0;

		for (int k = 1; k <= N + 1; k++) {
			int houses = countHouses(x, y, k);
			int profit = houses * M - getOperationCost(k);

			if (profit >= 0) {
				maxHouses = Math.max(maxHouses, houses);
			}
		}

		return maxHouses;
	}

	static int countHouses(int x, int y, int k) {
		int houses = 0;

		for (int i = x - k + 1; i < x + k; i++) {
			for (int j = y - k + 1; j < y + k; j++) {
				if (isValidPosition(i, j) && Math.abs(x - i) + Math.abs(y - j) < k) {
					houses += matrix[i][j];
				}
			}
		}
		return houses;
	}

	static boolean isValidPosition(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static int getOperationCost(int k) {
		return k * k + (k - 1) * (k - 1);
	}

}