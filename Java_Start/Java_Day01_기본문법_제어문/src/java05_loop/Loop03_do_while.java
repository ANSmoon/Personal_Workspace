package java05_loop;

import java.util.Scanner;

public class Loop03_do_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		do {
			System.out.println("숫자를 입력하세요. (0이면 종료)");
			num = sc.nextInt();
		} while (num != 0);

	}
}
