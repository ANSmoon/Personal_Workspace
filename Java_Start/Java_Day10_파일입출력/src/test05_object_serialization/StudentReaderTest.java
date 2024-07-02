package test05_object_serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentReaderTest {
	public static void main(String[] args) {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))){
			Object obj = ois.readObject();
			if(obj instanceof Student) {
				Student s = (Student) obj;
				System.out.println(s);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
