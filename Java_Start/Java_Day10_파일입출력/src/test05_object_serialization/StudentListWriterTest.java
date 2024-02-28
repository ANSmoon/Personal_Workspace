package test05_object_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentListWriterTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("현경찬", "서울5반"));
		list.add(new Student("이윤주", "대전3반"));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.dat"))){
			oos.writeObject(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
