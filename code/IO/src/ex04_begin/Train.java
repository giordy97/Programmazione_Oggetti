package ex04_begin;
import java.util.ArrayList;
import java.util.Iterator;

public class Train {
	protected static final long serialVersionUID = 1L;
	protected static final int nChars = 25;
	protected static final float priceKm = (float) 0.1;
	protected static final float priceKmExpress = (float) 0.2;
	protected static final float priceKmRestaurant = (float) 0.05;

	protected Station start;
	protected Station end;
	protected ArrayList<Station> stops;

	protected String starttime;
	protected String endtime;
	protected int places;
	protected int km;

	public Train(Station start, Station end, String starttime, String endtime, int km, int places) {
		this.start = start;
		this.end = end;
		this.starttime = starttime;
		this.endtime = endtime;
		this.km = km;
		this.places = places;

		this.stops = new ArrayList<Station>();
	}

	public Station getStart() {
		return start;
	}

	public void setStart(Station start) {
		this.start = start;
	}

	public Station getEnd() {
		return end;
	}

	public void setEnd(Station end) {
		this.end = end;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public void addStop(Station stop) {
		stops.add(stop);
	}

	public void removeStopByName(String stopName) {
		for (Iterator<Station> i = stops.iterator(); i.hasNext();) {
			Station stop = (Station) i.next();
			if (stop.getName().equals(stopName)) {
				i.remove();
			}
		}
	}

	public void removeStopByCode(String stopName) {
		for (Iterator<Station> i = stops.iterator(); i.hasNext();) {
			Station stop = (Station) i.next();
			if (stop.getCode().equals(stopName)) {
				i.remove();
			}
		}
	}

	public ArrayList<Station> getStops() {
		return stops;
	}

	public void setStops(ArrayList<Station> stops) {
		this.stops = stops;
	}

	public int getNumberOfStops() {
		return stops.size();
	}

	public float getMaxMoney() {
		return places * priceKm * km;
	}

	public String toString() {
		// StringBuffers are mutable Java Strings
		// Here trains build a char-oriented representation of themselves
		StringBuffer out = new StringBuffer();

		out.append(getClass().getName() + ",");
		out.append(getStart().toString() + ",");
		out.append(getEnd().toString() + ",");

		out.append(this.getStops().size() + ",");
		for (Station s : getStops()) {
			out.append(s.toString() + ",");
		}

		out.append(getStarttime() + ",");
		out.append(getEndtime() + ",");
		out.append(Integer.toString(getPlaces()) + ",");
		out.append(Integer.toString(getKm()) + ",");
		return out.toString();
	}
}
