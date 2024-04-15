import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test1_대전_04반_문범수 {
	static int N, M, result, max;
	static int[][] matrix; // 차지 영역 행렬
	static int[] countArr; // 각 고양이가 차지한 영역의 갯수 저장 배열
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());

		// 반복문 시작
		for (int index = 1; index <= total; index++) {
			token = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			matrix = new int[N][N];
			countArr = new int[M + 1];
			result = 0;
			max = Integer.MIN_VALUE;

			// 각 위치 입력
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
					countArr[matrix[i][j]]++;
				}
			}

			// 2차원 배열을 돌면서 최댓값을 탐색한다.
			for (int i = 1; i < M + 1; i++) {
				max = Math.max(max, countArr[i]);
			}

			// 처음부터 다시 돌면서 처음으로 최댓값을 찾는 순간 그 index를 result에 저장한다.
			for (int i = 1; i < M + 1; i++) {
				if (countArr[i] == max) {
					result = i;
					break;
				}
			}
			System.out.println("#" + index + " " + result);
		}
	}
}