package loop;

public class Loop {
	public static void main(String[] args) {
		for(int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}

		System.out.println("");
		
		int j = 1;
		
		for(;j < 10; j ++) {
			System.out.print(j + " ");
		}
		
		System.out.println("");
		
		int k = 1;
		while(k < 10) {
			System.out.print(k + " ");
			k++;
		}

		System.out.println("");
		
		int m = 1;
		do {
			System.out.print(m + " ");
			m++;
		} while (m<10);
		
		
		
		
	}
}