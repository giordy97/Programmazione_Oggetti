package ex02;

public class OrderedStudent implements Comparable<OrderedStudent> {
	private String name;
	private String surname;
	private double average;

	public OrderedStudent(String name, String surname, double average) {
		this.name = name;
		this.surname = surname;
		this.average = average;
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

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String toString() {
		return name + " " + surname + " " + average;
	}

	public int compareTo(OrderedStudent other) {
		int lastCmp = surname.compareTo(other.surname);
		if (lastCmp != 0) {
			return lastCmp;
		}
		
		lastCmp = (average < other.average) ? 1 : -1;
		return lastCmp;
	}
}
