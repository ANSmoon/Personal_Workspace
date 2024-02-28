package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest1 {
	public static void main(String[] args) {
		// ByteStream을 이용해서 이미지(파일)를 입출력
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("cat.jpg");
			fos = new FileOutputStream("cat-copy.jpg");
			
			int b; // File로부터 읽어올 데이터를 임시저장할 변수.
			// 1 바이트씩 저장, 더이상 읽을 값이 없으면 -1
			
			while((b = fis.read()) != -1) { // 1바이트를 읽어와서, -1이 아니라면.
				// b에 바이트를 하나 읽어왔음.
				fos.write(b);
			}
			System.out.println("복사가 끝났습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// fis 가 null일수도 있다.				
				if(fis != null)
					fis.close();
				if(fos != null)
					fos.close();
				System.out.println("스트림이 닫혔습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사실은, 스트림을 닫아줘야 한다.
	}

}
