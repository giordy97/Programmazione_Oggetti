package ex03;

/**
 * Data l'interfaccia MyList (vedi codice) costruire due classi MyArrayList e MyLinkedList
 * che implementano l'interfaccia utilizzando un vettore di oggetti e una lista linkata.
 * Le due classi devono soddisfare il caso seguente.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	
	public static void main(String[] args) {
		int n = 10;
		
		//MyList l = new MyArrayList();
		MyList l = new MyLinkedList();
		
		// add elements to the list
		for (int i = 0; i < n; i++) {
			l.add(new Integer(i));
		}
		
		// print the list
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

	}
}