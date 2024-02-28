
public class Array05_2차원배열_실습문제 {
	public static void main(String[] args) {
		int[][] grid = {
				{2,3,4,1,6},
				{2,5,6,7,8},
				{0,8,1,2,6},
				{8,7,3,2,7}
		};
		
		// 전체를 순회하며 3의 배수의 개수와 총합을 구해보자
		
		int cnt = 0;
		int sum = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] % 3 == 0) {
					cnt++;
					sum += grid[i][j];
				}
			}
		}
		System.out.printf("총 갯수 : %3d \n총 합  : %3d",cnt, sum);
	}
	
	
}
