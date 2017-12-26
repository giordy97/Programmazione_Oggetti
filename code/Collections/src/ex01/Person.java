package ex01;

public class Person implements Comparable<Person> {
	String name;
	String surname;
	String phone;
	
	public Person(String name, String surname, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Person o) {
		return surname.compareTo(o.surname);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", phone=" + phone + "]";
	}
}
