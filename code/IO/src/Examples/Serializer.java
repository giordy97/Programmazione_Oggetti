package Examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class for reading and writing serialized objects
 * 
 * @author Nicola Bicocchi
 *
 */
public class Serializer {
	String filename;

	public Serializer(String filename) {
		this.filename = filename;
	}

	/**
	 * Serializes an array of Students
	 * @param v	The array of students
	 */
	public void serialize(Student[] v) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			for (Student s : v) {
				out.writeObject(s);
			}
			out.close();
		} catch(IOException i) {
			i.printStackTrace();
		}
	}

	/**
	 * De-serializes an array of students
	 * @return	The array of students
	 */
	public Student[] deserialize(int n) {
		Student[] v = new Student[n];
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(filename));

			for (int i = 0; i < n; i++) {
				Student s = (Student)in.readObject();
				v[i] = s;
			}
		} catch(IOException ex01) {
			ex01.printStackTrace();
		} catch(ClassNotFoundException ex02) {
			ex02.printStackTrace();
		}
		return v;
	}

	public static void main(String [] args) {
		int n = 3;
		Student[] v = new Student[n];
		
		v[0] = new Student("Nicola", "Bicocchi", 2011, 28.0);
		v[1] = new Student("Mario", "Rossi", 2010, 27.0);
		v[2] = new Student("Pino", "Grossi", 2009, 26.0);
		
		for (Student s : v) {
			System.out.println(s);
		}

		Serializer es = new Serializer("students.data");
		es.serialize(v);
		v = es.deserialize(n);
		
		for (Student s : v) {
			System.out.println(s);
		}

	}
}