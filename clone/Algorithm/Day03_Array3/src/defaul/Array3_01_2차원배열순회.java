package defaul;

public class Array3_01_2차원배열순회 {
	public static void main(String[] args) {
		// 2차원 배열 초기화
		int[][] arr = new int [3][3];
		
		// 행 우선순회와 동시에 값 초기화
		int num = 1;
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[0].length; c++) {
				arr[r][c] = num++;
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		
		// 열 우선순회
		System.out.println("열 우선순회");
		for(int c = 0; c < arr[0].length; c++) {
			for(int r = 0; r < arr.length; r++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		
		// 지그재그 순회
		System.out.println("지그재그 순회");
		for(int r = 0; r < arr.length; r++) {
			if(r%2 == 0) {
				for(int c = 0; c < arr[0].length; c++) {
					System.out.print(arr[r][c] + " ");
				}	
			}
			else {
				for(int c = arr[0].length - 1; c >= 0; c--) {
					System.out.print(arr[r][c] + " ");
				}	
			}
			System.out.println();
		}
	}
}
