package ex03;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {
	public Student getStudent() {
		System.out.println("Inserire uno studente su una singola linea (nome, cognome, anno imm., media)");
		Scanner scr = new Scanner(System.in);
		String fields = scr.nextLine();
		scr.close();
		
		StringTokenizer st = new StringTokenizer(fields, ",");
		String name = st.nextToken();
		String lastName = st.nextToken();
		int year = Integer.parseInt(st.nextToken());
		double average = Double.parseDouble(st.nextToken());
		return new Student(name, lastName, year, average);
	}

	public void StoreText(Student s, String filename) throws IOException {
		BufferedWriter out = null;
		out = new BufferedWriter(new FileWriter(filename));
		out.write(s.firstName + ',');
		out.write(s.lastName + ',');
		out.write(new Integer(s.yearBegin).toString() + ',');
		out.write(new Double(s.average).toString() + '\n');
		out.close();
	}
	
	public void StoreBinary(Student s, String filename) throws IOException {
		DataOutputStream out = null;
		out = new DataOutputStream(new FileOutputStream(filename));
		out.writeChars(s.firstName);
		out.writeChars(s.lastName);
		out.writeInt(s.yearBegin);
		out.writeDouble(s.average);
		out.close();
	}
	
	public void StoreObject(Student s, String filename) throws IOException {
		ObjectOutputStream out = null;
		out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(s);
		out.close();
	}
}
