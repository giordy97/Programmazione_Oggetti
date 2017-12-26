package ex04;

import java.util.GregorianCalendar;

/**
 * A class representing a Book
 * @author Nicola Bicocchi
 *
 */
public class Book extends Publication {
	int ISBN;

	/**
	 * @param title
	 * @param pubDate
	 * @param ISBN
	 */
	public Book(String title, GregorianCalendar pubDate, int ISBN) {
		super(title, pubDate);
		this.ISBN = ISBN;
	}
}
