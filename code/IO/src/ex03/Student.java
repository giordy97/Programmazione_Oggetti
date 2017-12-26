package ex03;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	public String firstName;
	public String lastName;
	public int yearBegin;
	public double average;
	
	public Student(String firstName, String lastName, int yearBegin, double average) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBegin = yearBegin;
		this.average = average;
	}
	
	@Override
	public String toString() {
		return "Student [FirstName=" + firstName + ", LastName=" + lastName + ", yearBegin=" + yearBegin + ", average="
				+ average + "]";
	}
}
