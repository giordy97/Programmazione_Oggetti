package ex08;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Rent implements a rent of an Item
 * to a Person for a delimited time frame
 * 
 * @see Person, Item
 */
public class Rent {
	protected Item item;
	protected Person person;
	protected DateTime begin;
	protected DateTime end;
	
	public Rent(Item item, Person person,
			DateTime begin, DateTime end) {
		this.item = item;
		this.person = person;
		this.begin = begin;
		this.end = end;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public DateTime getBegin() {
		return begin;
	}

	public void setBegin(DateTime begin) {
		this.begin = begin;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public String toString() {
		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy");
		return item + ", " + person + ", " + f.print(begin) + ", " + f.print(end);
	}
}
