package StudentManager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable {

	private static final long serialVersionUID = -1983646416178160084L;
	private String ID;
	private String name;
	private String surname;
	private Date birthDate;
	private ArrayList<Course> courses;
	
	public Student(String ID, String name, String surname, Date birthDate) {
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.courses = new ArrayList<Course>();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public String toString() {
		return name + " " + surname + " " + ID + " " + birthDate + " " + courses.size();
	}
	
}
