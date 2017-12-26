package ex06;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a class able to receive a List<String>, check all the strings using StringChecker, 
 * and remove from the list all the invalid strings. Remember Iterators, since you're going
 * to modify a list while cycling over it!
 * 
 * Check your code with the following main.
 * @author Nicola Bicocchi
 *
 */
public class TestApp {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("a6r6t8f0d0e");
		l.add("66r6t8r0d6e");
		l.add("B4r6G8f1f2e");
		l.add("a6r6t8f0eee");
		l.add("a7r7t7f7d7e");
		
		new ListChecker().check(l);
		
		for (String s : l) {
			System.out.println(s);
		}
	}

}
