package ex06;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ListChecker {
	public void check(List<String> l) {
		StringChecker sc = new StringChecker();
		for (Iterator<String> i = l.iterator(); i.hasNext(); ) {
			try {
				sc.check(i.next());
			} catch (ParseException e) {
				i.remove();
			}
		}
	}
}
