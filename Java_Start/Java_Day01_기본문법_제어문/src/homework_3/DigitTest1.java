package homework_3;

public class DigitTest1 {
	public static void main(String[] args) {
		int i = 1;
		int condition = 5;
		int cnt = 0;
		int space = 0;
		int number = 15;

		while (i <= number) {
			System.out.printf("%3d", i);
			i++;
			cnt++;

			if (condition == cnt) {
				System.out.println();
				condition--;
				cnt = 0;
				space++;
				if (space == 1) {
					System.out.print("   ");
				} else if (space == 2) {

					System.out.print("      ");
				} else if (space == 3) {

					System.out.print("         ");
				} else if (space == 4) {

					System.out.print("            ");
				}
			}

		}
	}
}
