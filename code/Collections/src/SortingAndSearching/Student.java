package SortingAndSearching;

public class Student implements Comparable<Student> {
	protected String name;
	protected String lastname;
	protected double average;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public Student(String name, String lastname, double average) {
		this.name = name;
		this.lastname = lastname;
		this.average = average;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", lastname=" + lastname
				+ ", average=" + average + "]";
	}

	@Override
	public int compareTo(Student s) {
		int cmp = lastname.compareTo(s.lastname);
		if (cmp!=0) return cmp;
		return name.compareTo(s.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
