package ex02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * The Collections class implements a set of useful methods for sorting and searching Collection
 * implementations (e.g., ArrayList, LinkedList).
 * 
 * 1. Develop a concrete class (namely OrderedStudent) representing name, surname and
 * average of a student. Define a natural ordering using the Comparable interface. More
 * specifically, instances of OrderedStudent have to be sorted using both surname and
 * average (in case of identical surnames).
 * 2. Test the implemented solution using the Collections.sort() method.
 * 3. Implement an alternative sorting, without modifying the OrderedStudent, class by
 * using the Comparator interface.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		ArrayList<OrderedStudent> l = new ArrayList<OrderedStudent>();
		l.add(new OrderedStudent("Marco", "Rossi", 28.0));
		l.add(new OrderedStudent("Giulia", "Bianchi", 24.0));
		l.add(new OrderedStudent("Annalisa", "Gialli", 22.0));
		l.add(new OrderedStudent("Carlo", "Gialli", 24.0));
		l.add(new OrderedStudent("Luca", "Gialli", 22.0));
		
		System.out.println("1st Ordering...");
		Collections.sort(l);
		for (OrderedStudent s : l) {
			System.out.println(s);
		}
		
		System.out.println("2nd Ordering...");
		Collections.sort(l, new Comparator<OrderedStudent>() {
			public int compare(OrderedStudent s0, OrderedStudent s1) {
				return s0.getName().compareTo(s1.getName());
			}
	    });
		for (OrderedStudent s : l) {
			System.out.println(s);
		}
	}
}
