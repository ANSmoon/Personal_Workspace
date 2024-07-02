import java.util.Arrays;
import java.util.Scanner;

public class Algo2_대전_4반_문범수 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스 입력 및 시작위치를 위한 변수 설정
		int total = sc.nextInt();
		int index = 1;
		int start_i;
		int x = 0;
		int start_j;
		int y = 0;
		
		while (index <= total) {
			// 행과 열 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 2차원 배열로 선언
			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
					// 시작위치 설정
					if (arr[i][j] == -1) {
						x = i;
						y = j;
					}
				}
			}
			
			// 4방향으로 갔을 때 소모되는 에너지 합
			int[] sum = new int[4];

			for (int k = 0; k < 4; k++) {
				start_i = x;
				start_j = y;
				int cnt = 0;
				// 인덱스 에러가 나지 않게 하기 위한 설정
				while (start_i < N && start_j < M && start_i >= 0 && start_j >= 0) {
					// 끝부분에 도달할 시 종료
					if (start_i == 0 || start_i == N - 1 || start_j == 0 || start_j == M - 1) {
						break;
					} else if (k == 0 && start_i < N) { // 행 방향 탐색[아래]
						sum[k] += arr[++start_i][start_j];
						if(arr[start_i][start_j] == 10) { // 벽을 만났을 때 상황 구현
							cnt++;
						}
						if(cnt == 2) {
							sum[k] = 1000;
						}
					} else if (k == 1 && start_j < M) { // 열 방향 탐색[오른쪽]
						sum[k] += arr[start_i][++start_j];
						if(arr[start_i][start_j] == 10) { // 벽을 만났을 때 상황 구현
							cnt++;
						}
						if(cnt == 2) {
							sum[k] = 1000;
						}
					} else if (k == 2 && start_i > 0) { // 행 방향 탐색[위]
						sum[k] += arr[--start_i][start_j];
						if(arr[start_i][start_j] == 10) { // 벽을 만났을 때 상황 구현
							cnt++;
						}
						if(cnt == 2) {
							sum[k] = 1000;
						}
					} else if (k == 3 && start_j > 0) { // 열 방향 탐색[왼쪽]
						sum[k] += arr[start_i][--start_j];
						if(arr[start_i][start_j] == 10) { // 벽을 만났을 때 상황 구현
							cnt++;
						}
						if(cnt == 2) {
							sum[k] = 1000;
						}
					}
				}
			}
			// 구해진 4방향을 오름차순으로 정렬한 후 최솟값 출력
			int min_index = 0;
			int temp = 0;
			for(int i = 0; i < sum.length - 1; i++) {
				min_index = i;
				for(int j = i + 1; j < sum.length; j++) {
					if(sum[min_index] > sum[j]) {
						min_index = j;
					}
				}
				temp = sum[i];
				sum[i] = sum[min_index];
				sum[min_index] = temp;
			}
			System.out.println("#" + index + " " + sum[0]);
			index++;
		}
		sc.close();
	}
}
