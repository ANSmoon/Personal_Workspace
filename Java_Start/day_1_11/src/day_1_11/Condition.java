package day_1_11;

public class Condition {
	public static void main(String[] args) {
		int i = 1;
		
		if(i % 2 == 1) {
			System.out.println(i + " is odd.");
		}
		else if(i % 2 == 0){
			System.out.println(i + " is even.");
		}
		else {
			System.out.println(i + " is zero.");
		}
		System.out.println("Break!");
		
		int k = 150;
		if(k < 100) {
			System.out.println(k + " is under the 100.");
		}
		else if(k < 200) {
			System.out.println(k + " is middle of 100 and 200");
		}
		else {
			System.out.println(k + "is over the 200");
		}
		
		int j = 1;
		
		switch (j) {
			case 1:
				System.out.println(1 + " is number one");
				System.out.println(1 + " is only one");
				j++;
			case 2:
				System.out.println(2 + " is number two");
				System.out.println(2 + " ^^;;");
				j++;
			default:
				System.out.println("It is neither one and two");
				break;
		}
		
		char a = 'H';
		String b = "HI";
		
		
			
		
	}
}
