package ex01;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A PhoneBook implementation internally using HashMap
 * @author Nicola Bicocchi
 * @see PhoneBook
 *
 */
public class PhoneBookHash implements PhoneBook {
	ArrayList<Person> pb;
	HashMap<String, Person> indexName;
	HashMap<String, Person> indexSurname;
	HashMap<String, Person> indexNumber;
		
	public PhoneBookHash() {
		pb = new ArrayList<Person>();
		indexName = new HashMap<String, Person>();
		indexSurname = new HashMap<String, Person>();
		indexNumber = new HashMap<String, Person>();
	}

	public void addPerson(Person p) {
		pb.add(p);
		indexName.put(p.getName(), p);
		indexSurname.put(p.getSurname(), p);
		indexNumber.put(p.getPhone(), p);
	}
	
	public Person searchByName(String name) {
		if (indexName.containsKey(name)) {
			return indexName.get(name);
		}
		return null;
	}
	
	public Person searchByLastname(String lastname) {
		if (indexSurname.containsKey(lastname)) {
			return indexSurname.get(lastname);
		}
		return null;
	}
	
	public Person searchByNumber(String phone) {
		if (indexNumber.containsKey(phone)) {
			return indexNumber.get(phone);
		}
		return null;
	}
	
	public void deleteByNumber(String phone) {
		if (indexNumber.containsKey(phone)) {
			Person p = indexNumber.get(phone);
			
			indexName.remove(p.getName());
			indexSurname.remove(p.getSurname());
			indexNumber.remove(p.getPhone());
			
			pb.remove(p);
		}
	}
}
