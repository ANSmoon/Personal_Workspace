package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		
		char[][] ch = new char[100][100];
		for(int i = 0; i < 100; i++) {	
			String str = reader.readLine();
			System.out.println(str.length());
			for(int j = 0; j < 100; j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < ch.length; i++) {
			for(int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}

	}
}
