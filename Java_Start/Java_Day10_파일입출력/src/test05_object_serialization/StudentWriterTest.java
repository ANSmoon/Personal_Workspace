package test05_object_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentWriterTest {
	public static void main(String[] args) {
		
		Student s = new Student("송창용", "서울7반"); // 힙영역에 객체 생성됨
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))){
			oos.writeObject(s);
			System.out.println("끝.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
