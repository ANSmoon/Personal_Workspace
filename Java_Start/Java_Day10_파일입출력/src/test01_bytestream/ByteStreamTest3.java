package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest3 {
	public static void main(String[] args) {
		// ByteStream을 이용해서 이미지(파일)를 입출력
		
		
		// try with resources.
		try (FileInputStream fis = new FileInputStream("dog2.jpg"); 
				FileOutputStream fos = new FileOutputStream("dog2-copy.jpg");
				) { // () 안에 내가 사용할 스트림 변수를 선언 & 생성
			// ; 로 끝나는 여러 문장 가능.
			
			// buffer를 사용하면 반환되는 b의 의미가 바뀐다.
			int b; // 읽어온(채워준 바이트) 개수(못 읽었다면 -1)
			byte[] buffer = new byte[10];
			
			while((b = fis.read(buffer)) != -1) { // 1바이트를 읽어와서, -1이 아니라면.
				// b에 바이트를 하나 읽어왔음.
				fos.write(buffer, 0, b);
			}
			System.out.println("복사가 끝났습니다.");
			System.out.println("스트림은 알아서 닫힙니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
