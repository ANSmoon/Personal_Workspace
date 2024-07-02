package test02_characterstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest2 {
	public static void main(String[] args) {
		
		try(FileReader reader = new FileReader("big_input.txt");
			FileWriter writer = new FileWriter("big_input_copy_2.txt")
				){
			
			int c; // reader가 채워준 char의 갯수.(끝났다면 -1)
			char[] buffer = new char[10];
			
			while((c = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, c); // 읽어온 갯수만큼 출력한다.
			}
			System.out.println("끝.");
			System.out.println("스트림은 알아서 닫혔습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
