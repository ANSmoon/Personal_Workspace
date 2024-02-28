package defaul;
import java.util.Scanner;

public class Array3_02_deltaArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		int pr = 2;
		int pc = 2;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (true) {
			int d = sc.nextInt();
			
			arr[pr][pc] = 0;
			
			if(!(0 <= pr + dr[d] && pr + dr[d] < arr.length
					&& 0 <= pc + dr[d] && pc + dr[d] < arr.length)) {	
				continue;
			}
			
			pr = pr + dr[d];
			pc = pc + dc[d];
			
			arr[pr][pc] = 1;
			
			System.out.println();
			for(int r = 0; r < arr.length; r++) {
				for(int c = 0; c < arr[0].length; c++) {
					System.out.printf(arr[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
