package Examples;

import java.util.LinkedList;

/**
 * Simple class showing main functionalities of LinkedLists
 * @author Nicola Bicocchi
 * @see    List, Queue
 */
public class LinkedListExample {
	public static void main(String[] args) {
		String act;
		LinkedList<Integer> l = new LinkedList<Integer>();

		act = "Adding elements...";
		System.out.println(act);
		l.add(2);
		l.add(14);
		l.add(3);
		l.add(7);

		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}

		act = "Peek element...";
		System.out.println(act);
		System.out.println(l.peek());
		
		act = "Peek element...";
		System.out.println(act);
		System.out.println(l.peek());
		
		act = "Poll element...";
		System.out.println(act);
		System.out.println(l.poll());
		
		act = "Showing content...";
		System.out.println(act);
		for (int i : l) {
			System.out.println(i);
		}
		
		act = "Get first element...";
		System.out.println(act);
		System.out.println(l.getFirst());
		
		act = "Get last element...";
		System.out.println(act);
		System.out.println(l.getLast());

	}

}
