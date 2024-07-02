/*
author : 문범수
date : 2024-01-29
subject : 반복문
name : Test1.java
*/

public class Test1 {
	public static void main(String[] args) {
		int N = 10;

		// '*' 를 넣기 위해 char 배열을 N 크기만큼 생성
		char[][] arr = new char[N][N];

		// 배열에 *를 문제의 조건에 맞게 넣으면서 프린트할 시 조건에 맞는 모양이 나오도록 설정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || i == N - 1) {
					arr[i][j] = '*';
				}
				if (j == 0 || j == N - 1) {
					arr[i][j] = '*';
				}
				System.out.print(arr[i][j]);
			}
			System.out.println(); // 행이 변할 때 마다 줄 바꿈
		}
	}
}
