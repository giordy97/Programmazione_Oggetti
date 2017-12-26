package ex01;


/**
 * A customer asked our company to build a large phonebook. The system will be queried 
 * alternatively with a telephone number or name or a surname. Independently from the kind of
 * input data, the system will have to provide the whole data about that person.
 * 
 *  1. Implement a class PhoneBook able to (i) insert a new person, (ii) retrieve a person by
 *  name, surname or phone number, (iii) delete a person by phone number.
 *  2. If you implemented PhoneBook by making use of ArrayList you should recall that
 *  searching objects within lists requires sorting or exhaustive searches. Implement a new
 *  version of PhoneBook using HashMaps for indexing the data.
 *  3. How can you relate the two implementations? Abstract classes? Interfaces? Which is
 *  better and why?
 *  
 * @author Nicola Bicocchi
 *
 */
public class TestApp {	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBookHash();
		pb.addPerson(new Person("Nicola", "Zicocchi", "34567"));
		pb.addPerson(new Person("Marco", "Rizzo", "45243"));
		pb.addPerson(new Person("Luisa", "Poppi", "24564"));
		
		System.out.println(pb.searchByName("Marco"));
		System.out.println(pb.searchByLastname("Poppi"));
		
		// do not exist!
		System.out.println(pb.searchByNumber("1111"));
		
		// delete an element!
		pb.deleteByNumber("24564");
		System.out.println(pb.searchByLastname("Poppi"));
	}
}
