package ex08;
import java.text.ParseException;
import java.util.ArrayList;

import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Biblioteca {
	ArrayList<Rent> rents;

	public Biblioteca() {
		try {
			rents = load();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (Rent r : rents) {
			System.out.println(r);
		}

		System.out.println("- Longest Rent:");
		System.out.println(getLongestRent());

		System.out.println("- Faulty Rents:");
		for (Rent r : getFaults()) {
			System.out.println(r);
		}

	}

	private ArrayList<Rent> load() throws ParseException {
		ArrayList<Rent> r = new ArrayList<Rent>();
		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy");

		Person p1 = new Person("0001", "Darrell", "Abbott");
		Person p2 = new Person("0002", "Nick", "Drake");

		Item i1 = new Book("Soffocare", 2002, 170);
		Item i2 = new Dvd("Moon", 2011, 130);

		r.add(new Rent(i1, p1, f.parseDateTime("15/06/2011"), f.parseDateTime("15/07/2011")));
		r.add(new Rent(i1, p2, f.parseDateTime("10/07/2011"), f.parseDateTime("20/07/2011")));
		r.add(new Rent(i1, p1, f.parseDateTime("25/08/2011"), f.parseDateTime("14/09/2011")));

		r.add(new Rent(i2, p2, f.parseDateTime("10/07/2011"), f.parseDateTime("20/07/2011")));
		r.add(new Rent(i2, p1, f.parseDateTime("25/08/2011"), f.parseDateTime("14/10/2011")));

		return r;
	}

	private ArrayList<Rent> getFaults() {
		ArrayList<Rent> r = new ArrayList<Rent>();
		for (int i = 0; i < rents.size() - 1; i++) {
			for (int j = i + 1; j < rents.size(); j++) {
				Rent r1 = rents.get(i);
				Rent r2 = rents.get(j);
				Interval i1 = new Interval(r1.getBegin(), r1.getEnd());
				Interval i2 = new Interval(r2.getBegin(), r2.getEnd());
				if (i2.overlaps(i1) && r1.getItem() == r2.getItem()) {
					r.add(rents.get(i));
					r.add(rents.get(j));
				}
			}
		}
		return r;
	}

	private Rent getLongestRent() {
		Rent longestRent = rents.get(0);

		for (Rent r : rents) {
			if ((r.getEnd().getMillis() - r.getBegin().getMillis()) > 
			(longestRent.getEnd().getMillis() - longestRent.getBegin().getMillis())) {
				longestRent = r;
			}
		}
		return longestRent;
	}
}
