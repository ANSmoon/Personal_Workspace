/*
author : 문범수
date : 2024-01-29
subject : File 입출력
name : Test3.java
*/

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test3 {
	public static void main(String[] args) {
		// 각각의 변수 초기화
		
		int math = 0;
		int science = 0;
		int english = 0;
		int sum = 0;
		float avg = 0;
		int sc1 = 90;
		int sc2 = 82;
		int sc3 = 75;

		// 먼저 input.txt 생성 및 점수 입력
		try {
			@SuppressWarnings("resource")
			OutputStream foo = new FileOutputStream("input.txt");
			try {
					foo.write(sc1);
					foo.write(sc2);
					foo.write(sc3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 수학, 과학, 영어 변수에 input.txt로 부터 읽어들인 값들 입력
		try {
			@SuppressWarnings("resource")
			FileInputStream fii = new FileInputStream("input.txt");
			try {
				math = fii.read();
				science = fii.read();
				english = fii.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 총합 및 평균 계산 및 출력
		sum = math + science + english;
		avg = ((float)sum / 3);
		System.out.println("---성적표---");
		System.out.println("수학 : " + math + "점");
		System.out.println("과학 : " + science + "점");
		System.out.println("영어 : " + english + "점");
		System.out.printf("평균 : %.2f점\n",avg);
		System.out.println("총합 : " + sum);
		
	}
}
