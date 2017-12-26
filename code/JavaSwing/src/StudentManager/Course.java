package StudentManager;


import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 9093727422679857871L;
	private String ID;
	private String name;
	private int nteachers;
	private int totalCredits;
	
	public Course(String ID, String name, int nteachers, int totalCredits) {
		this.ID = ID;
		this.name = name;
		this.nteachers = nteachers;
		this.totalCredits = totalCredits;
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

	public int getNteachers() {
		return nteachers;
	}

	public void setNteachers(int nteachers) {
		this.nteachers = nteachers;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	
	public String toString() {
		return getName();
	}
}
