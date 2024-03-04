import java.util.Arrays;
import java.util.Scanner;

public class IM_test {
	static int ans, N, M1, M2;
	static int[] arr, build1, build2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int index = 1;

		while (index <= total) {
			ans = 0;
			N = scanner.nextInt();
			M1 = scanner.nextInt();
			M2 = scanner.nextInt();
			arr = new int[N];
			build1 = new int[M1];
			build2 = new int[M2];

			// 각 블록의 무게 입력
			for (int i = 0; i < N; i++) {
				arr[i] = scanner.nextInt();
			}

			// 오름차순 정렬
			Arrays.sort(arr);

			// logic : 무게가 큰 블록이 먼저 아래로 오도록 각 건물을 짓는다.
			// 높이 제한 있다! (M1, M2 가 각각 높이 제한)
			int tmp1 = 0;
			int tmp2 = 0;
			boolean[] visited = new boolean[N];

			if(M1 >= M2) {
				for (int i = arr.length - 1; i >= 0; i = i - 2) {
					if (tmp2 == M2) {
						break;
					}
					build2[tmp2++] = arr[i];
					visited[i] = true;
				}
				
				for (int i = arr.length - 1; i >= 0; i--) {
					if(visited[i] == true) {
						continue;
					}
					build1[tmp1++] = arr[i];
				}
			}else {
				for (int i = arr.length - 1; i >= 0; i = i - 2) {
					if (tmp1 == M1) {
						break;
					}
					build1[tmp1++] = arr[i];
					visited[i] = true;
				}
				
				for (int i = arr.length - 1; i >= 0; i--) {
					if(visited[i] == true) {
						continue;
					}
					build2[tmp2++] = arr[i];
				}
			}

			// 무게는 무조건 1 이상이기 때문에 0값이 있다면 총 무게에 값을 더하지 않는다.

			for (int i = 0; i < M1; i++) {
				ans += build1[i] * (i + 1);
			}
			for (int i = 0; i < M2; i++) {
				ans += build2[i] * (i + 1);
			}

			System.out.println("#" + index + " " + ans);
			index++;
		}
		scanner.close();
	}
}
