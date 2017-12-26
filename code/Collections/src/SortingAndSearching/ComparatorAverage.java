package SortingAndSearching;

import java.util.Comparator;

/**
 * A simple comparator sorting students by average
 * @author Nicola Bicocchi
 *
 */
public class ComparatorAverage implements Comparator<Student> {
	@Override
	public int compare(Student s0, Student s1) {
		// generate Double objects for comparison
		Double d0 = new Double(s0.getAverage());
		Double d1 = new Double(s1.getAverage());
		// actual comparison
		return d0.compareTo(d1);
	}
}
