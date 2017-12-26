package ex01;
import java.util.ArrayList;


/**
 * A PhoneBook implementation internally using ArrayList
 * To be used for small and simple applications. Slow! 
 * @author Nicola Bicocchi
 * @see PhoneBook
 *
 */
public class PhoneBookArray implements PhoneBook {
	ArrayList<Person> pb;
		
	public PhoneBookArray() {
		pb = new ArrayList<Person>();
	}

	public void addPerson(Person p) {
		pb.add(p);
	}
	
	
	/**
	 * Add a person to the PhoneBook
	 * @param name		Name of the person
	 * @param surname	Surname of the person
	 * @param phone		Phone of the person
	 */
	public void addPerson(String name, String surname, String phone) {
		pb.add(new Person(name, surname, phone));
	}
	
	public Person searchByName(String name) {
		for (Person p : pb) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public Person searchByLastname(String lastname) {
		for (Person p : pb) {
			if (p.getSurname().equals(lastname)) {
				return p;
			}
		}
		return null;
	}
	
	public Person searchByNumber(String phone) {
		for (Person p : pb) {
			if (p.getPhone().equals(phone)) {
				return p;
			}
		}
		return null;
	}
	
	public void deleteByNumber(String phone) {
		Person p = searchByNumber(phone);
		if (p != null) pb.remove(p);
	}
}
