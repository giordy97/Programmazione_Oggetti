package ex08;

/**
 * A simple DVD
 */
public class Dvd extends Item {
	protected int durata;
	
	public Dvd(String title, int year, int durata) {
		super(title, year);
		this.durata = durata;
	}
}