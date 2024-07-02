package test03_file;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		// File 클래스 : 파일 또는 폴더를 관리하기 위한 클래스
		
		File f = new File("big_input.txt"); // 상대경로
		// 실행 지점을 기준.
		
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath()); // 절대경로
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		
		File folder = new File("folder");
		folder.mkdir(); // 상대경로에 폴더가 만들어짐.
		System.out.println(folder.isDirectory());
		
	}
}
