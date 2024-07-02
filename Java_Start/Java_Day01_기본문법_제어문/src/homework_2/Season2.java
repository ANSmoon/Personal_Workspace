package homework_2;

import java.util.Scanner;

public class Season2 {
	public static void main(String[] args) {
		// Season2. java
		int j = 0;

		Scanner sx = new Scanner(System.in); // scanner 객체 생성
		while(j < 3) {						 // 총 3번의 입력
			System.out.println("월 입력 >>");
			int month = sx.nextInt();
			switch (month){
				case 3:
				case 4:
				case 5:						 // 3 ~ 5월은 봄에 해당
					System.out.println(month + "월은 봄입니다.");
					j++;
					break;
				case 6:
				case 7:
				case 8:						 // 6 ~ 8월은 여름에 해당
					System.out.println(month + "월은 여름입니다.");
					j++;
					break;
				case 9:
				case 10:
				case 11:					 // 9 ~ 11월은 가을에 해당
					System.out.println(month + "월은 가을입니다.");
					j++;
					break;
				case 12:
				case 1:
				case 2:						 // 12 ~ 2월은 겨울에 해당
					System.out.println(month + "월은 겨울입니다.");
					j++;
					break;		
			}
		}
		sx.close();
	}
}
