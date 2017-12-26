package ex02;


public class Student implements Comparable<Student> {
	String name;
	String surname;
	
	public Student(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + "]";
	}

	@Override
	public int compareTo(Student o) {
		return surname.compareTo(o.surname);
	}
	
	

}
