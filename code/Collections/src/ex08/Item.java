package ex08;

/**
 * A simple item generalizing books and DVDs
 */
public class Item {
	protected String title;
	protected int year;
	
	public Item(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	public String toString() {
		return title + " (" + year + ")";
	}
}
