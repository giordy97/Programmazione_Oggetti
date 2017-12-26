package ex07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
	
	/**
	 * Removes duplicates from a list using HashSets (long version)
	 * @param l	List to be freed from duplicates
	 */
	public static void removeDuplicates(List<Integer> l) {
		Set<Integer> s = new HashSet<Integer>(l);
		l.clear();
		l.addAll(s);
	}
	
	/**
	 * Removes duplicates from a list using HashSets (short version)
	 * @param l	List to be freed from duplicates
	 */
	public static void removeDuplicates_alt(List<Integer> l) {
		l = new ArrayList<Integer>(new HashSet<Integer>(l));
	}

}
