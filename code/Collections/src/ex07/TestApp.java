package ex07;

import java.util.ArrayList;
import java.util.List;

/**
 * Costruire una classe dotata di un solo metodo statico removeDuplicates che 
 * accetta una lista e ne rimuove i duplicati secondo il caso d'uso sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(3); 
		l.add(4); 
		l.add(3);
		
		for (int n: l) {
			System.out.println(n);
		}
		
		Util.removeDuplicates(l);
		
		for (int n: l) {
			System.out.println(n);
		}
	}


}
