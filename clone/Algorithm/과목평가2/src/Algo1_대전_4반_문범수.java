import java.util.Scanner;

public class Algo1_대전_4반_문범수 {
	public static void main(String[] args) throws Exception {
		// Scanner 입력 사용
		Scanner sc = new Scanner(System.in);
		
		// 전체 케이스 수 입력
		int total = sc.nextInt();
		int index = 1;
		while (index <= total) {
			int x = 0;
			int arr[] = new int[30];
			// 총 30개씩 1차원 배열로 입력
			while (x < 30) {
				arr[x++] = sc.nextInt();
			}

			int sum = 0;
			int max = 0;
			// 해당 요일부터 약 7일간 더해가며 더한값이 가장 큰 값을 출력
			for (int i = 0; i < 23; i++) {
				for (int j = i; j < i + 7; j++) {
					sum += arr[j];
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			System.out.println("#" + index + " " + max);

			index++;
		}
		sc.close();

		// 테스트 케이스
//1 0 1 0 0 1 1 1 1 0 
//1 1 0 0 1 0 0 1 0 1
//1 1 0 1 0 1 1 1 0 1
//1 0 1 0 0 1 1 1 1 0
//1 1 1 0 1 0 0 1 0 1 
//1 1 0 1 0 1 1 1 0 1

	}
}
