package ex08;

/**
 * A simple book
 */
public class Book extends Item {
	protected int pages;
	
	public Book(String title, int year, int pages) {
		super(title, year);
		this.pages = pages;
	}
}
