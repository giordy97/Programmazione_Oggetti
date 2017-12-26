package SortingAndSearching;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class showing how to use iterators for modifying collections
 * while iterating
 * @author Nicola Bicocchi
 *
 */
public class TestIterator {
	public static void main(String[] args) {
		// list instantiation and filling
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);

		// C-like syntax
		System.out.println("List Content:");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		// for-each syntax
		System.out.println("List Content:");
		for (int i : l) {
			System.out.println(i);
		}

		// iterator-based syntax
		System.out.println("List Content:");
		for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
		
		// remove an element from a list using iterators
		for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
			int n = i.next();
			if (n == 2) i.remove();
		}
		
		// add an element in a list using iterators
		// only ListIterator supports adding
		for (ListIterator<Integer> i = l.listIterator(); i.hasNext(); ) {
			int n = i.next();
			if (n == 1) i.add(17);
		}
		
		// show content of the list
		System.out.println("List Content:");
		for (int i : l) {
			System.out.println(i);
		}
		
		
	}
}
