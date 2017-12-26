package Examples;


import java.util.HashMap;

/**
 * Simple class showing main functionalities of LinkedLists
 * @author Nicola Bicocchi
 * @see    List, Queue
 */
public class HashMapExample {
	public static void main(String[] args) {
		String act;
		HashMap<Integer, String> l = new HashMap<Integer, String>();

		act = "Adding elements...";
		System.out.println(act);
		l.put(2, "Nicola");
		l.put(14, "Loris");
		l.put(3, "Luca");
		l.put(7, "Giorgio");
		
		act = "Removing elements...";
		System.out.println(act);
		System.out.println(l.remove(7));

		act = "Showing content...";
		System.out.println(act);
		for (int i : l.keySet()) {
			System.out.println(i + " -> " + l.get(i));
		}
		
		act = "Contains...";
		System.out.println(act);
		System.out.println(l.containsKey(3));
		
		act = "Getting keys...";
		System.out.println(act);
		for (int i : l.keySet()) {
			System.out.println(i);
		}
		
		act = "Getting values...";
		System.out.println(act);
		for (String s : l.values()) {
			System.out.println(s);
		}
	}

}
