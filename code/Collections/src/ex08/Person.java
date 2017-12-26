package ex08;

/**
 * Person encapsulates persons details
 */
public class Person {
	protected String name;
	protected String surname;
	protected String CF;
	
	public Person(String CF, String nome, String cognome) {
		this.CF = CF;
		this.name = nome;
		this.surname = cognome;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getCF() {
		return CF;
	}
	
	public String toString() {
		return name + " " + surname;
	}

}
