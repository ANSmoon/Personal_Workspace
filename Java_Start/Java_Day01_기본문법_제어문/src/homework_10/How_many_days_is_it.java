package homework_10;
import java.util.Scanner;

public class How_many_days_is_it {
	public static void main(String[] args) {
		System.out.println("월과 일을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);

		int month = sc.nextInt();
		int day = sc.nextInt();
		int sum = 0;

		switch (month) {
		case 1:
			sum += day;
			break;
		case 2:
			sum = 31 + day;
			break;
		case 3:
			sum = 31 + 28 + day;
			break;
		case 4:
			sum = 31 + 28 + 31 + day;
			break;
		case 5:
			sum = 31 + 28 + 31 + 30 + day;
			break;
		case 6:
			sum = 31 + 28 + 31 + 30 + 31 + day;
			break;
		case 7:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + day;
			break;
		case 8:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + day;
			break;
		case 9:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day;
			break;

		case 10:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
			break;

		case 11:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
			break;

		case 12:
			sum = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
			break;

		}
		System.out.printf("%d월 %d일은 %d번째 날입니다.\n", month, day, sum);

	}
}
