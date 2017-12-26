package Examples;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


/**
 * Simple class showing main functionalities of List implementations
 * @author Nicola Bicocchi
 *
 */
public class ArrayListExample {
	public static void main(String[] args) {
		String act;
		List<Integer> l = new ArrayList<Integer>();
		
		// We can use a LinkedList as well. Nothing changes!
		// List<Integer> l = new LinkedList<Integer>();
		
		act = "Adding elements...";
		System.out.println(act);
		l.add(2);
		l.add(14);
		l.add(3);
		l.add(7);
		
		act = "Adding element at specific position (position, value)...";
		System.out.println(act);
		l.add(1,17);
		
		act = "Getting an element...";
		System.out.println(act);
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		
		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}
		
		act = "Removing an element by index...";
		System.out.println(act);
		l.remove(1);
		
		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}
		
		act = "Check if contains an element...";
		System.out.println(act);
		System.out.println(l.contains(3));
		
		act = "Get size...";
		System.out.println(act);
		System.out.println(l.size());
		
		act = "Sorting...";
		System.out.println(act);
		Collections.sort(l);
		
		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}
		
		act = "Removing an element while iterating...";
		System.out.println(act);
		for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
			int n = i.next();
			if (n == 14) i.remove();
		}
		
		act = "Adding an element while iterating...";
		System.out.println(act);
		for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
			int n = i.next();
			if (n == 3) i.add(44);
		}
		
		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}
	}

}
