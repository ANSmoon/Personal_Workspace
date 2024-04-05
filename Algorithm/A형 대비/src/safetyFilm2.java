import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class safetyFilm2 {
	static int D, W, K, result; // D : row, W : col, K : pass number
	static int[][] film; // 보호필름 저장
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			result = Integer.MAX_VALUE;
			makeFilm(0, 0);
			System.out.println("#" + index + " " + result);
		}
	}

	// row : 약품을 주입할 행
	// cnt : 약품 주입 횟수
	static void makeFilm(int row, int cnt) {

		if(pass()) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(result < cnt) return;
		if(row == D) return;
		
		// 주입 X
		makeFilm(row + 1, cnt);

		// 약품 주입 전 복사본 저장
		// 1차원에 주입을 하니 1차원만 저장해도 됨.
		int[] tmp = new int[W];
		for (int i = 0; i < W; i++) {
			tmp[i] = film[row][i];
		}

		// A 주입
		injection(row, 0);
		makeFilm(row + 1, cnt + 1);

		// B 주입
		injection(row, 1);
		makeFilm(row + 1, cnt + 1);

		// 원상복구
		for (int i = 0; i < W; i++) {
			film[row][i] = tmp[i];
		}
	}

	static boolean pass() {
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c]) {
					cnt++;
				}else {
					cnt = 1;
				}
				if(cnt >= K) {
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		// 끝까지 도달에 성공한 경우
		return true;
	}

	// row번째 행에 약품 주입
	static void injection(int row, int drug) {
		for (int i = 0; i < W; i++) {
			film[row][i] = drug;
		}
	}
}