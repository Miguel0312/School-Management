package file;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import people.Student;

public class GetStudents {
	public static ArrayList<Student> go(){
		ArrayList<Student> school = new ArrayList<Student>();
		File f = new File("school.txt");
		try {
			ObjectInputStream fis;
			fis = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
					while(true)
						school.add((Student)fis.readObject());
			}catch(ClassNotFoundException e) {
			}catch(EOFException e) {
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			fis.close();
			}catch(EOFException e) {}
		catch(IOException e) {
				e.printStackTrace();
			}
		return school;
	}
}
