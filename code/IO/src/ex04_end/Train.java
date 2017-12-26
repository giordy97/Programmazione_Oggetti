package ex04_end;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Train implements Serializable {
	/**
	 * 
	 */
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

	public byte[] toByteArray() throws IOException {
		// Here trains build a byte-oriented representation of themselves
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(byteArray);

		out.writeBytes(String.format("%1$-" + nChars + "s", getClass().getName()));

		out.writeBytes(String.format("%1$-" + nChars + "s", getStart().getName())); 
		out.writeBytes(String.format("%1$-" + nChars + "s", getStart().getCode())); 
		out.writeBytes(String.format("%1$-" + nChars + "s", getStart().getLine())); 

		out.writeBytes(String.format("%1$-" + nChars + "s", getEnd().getName())); 
		out.writeBytes(String.format("%1$-" + nChars + "s", getEnd().getCode())); 
		out.writeBytes(String.format("%1$-" + nChars + "s", getEnd().getLine())); 

		out.writeInt(getStops().size());
		for (Station s : getStops()) {
			out.writeBytes(String.format("%1$-" + nChars + "s", s.getName())); 
			out.writeBytes(String.format("%1$-" + nChars + "s", s.getCode())); 
			out.writeBytes(String.format("%1$-" + nChars + "s", s.getLine())); 
		}

		out.writeBytes(String.format("%1$-" + nChars + "s", getStarttime()));
		out.writeBytes(String.format("%1$-" + nChars + "s", getEndtime()));
		out.writeInt(getPlaces());
		out.writeInt(getKm());

		return byteArray.toByteArray();
	}

	public static Train readChars(BufferedReader in) throws IOException {
		String line;
		String[] fields;

		if ((line = in.readLine()) == null) {
			return null;
		} else {
			fields = line.split(",");
		}

		int idx = 0;
		String className = fields[idx++];
		Station start = new Station(fields[idx++], fields[idx++], fields[idx++]);
		Station end = new Station(fields[idx++], fields[idx++], fields[idx++]);

		int nStops = Integer.parseInt(fields[idx++]);
		ArrayList<Station> stops = new ArrayList<Station>();
		for (int i = 0; i < nStops; i++) {
			stops.add(new Station(fields[idx++], fields[idx++], fields[idx++]));
		}

		String startTime = fields[idx++];
		String endTime = fields[idx++];

		int km = Integer.parseInt(fields[idx++]);
		int places = Integer.parseInt(fields[idx++]);

		Train t;
		// .endsWith gets rid of package names
		if (className.endsWith("TrainExpress")) {
			t = new TrainExpress(start, end, startTime, endTime, places, km);
			((TrainExpress)t).setRestaurantPlaces(Integer.parseInt(fields[idx++]));
		} else {
			t = new Train(start, end, startTime, endTime, places, km);
		}
		t.setStops(stops);
		return t;
	}

	public static Train readBinary(InputStream r) throws IOException {
		DataInputStream in = new DataInputStream(r);

		try {
			Train t = null;
			String className = readField(in);
			Station start = new Station(readField(in), readField(in), readField(in));
			Station end = new Station(readField(in), readField(in), readField(in));

			int nStops = in.readInt();
			ArrayList<Station> stops = new ArrayList<Station>();
			for (int i = 0; i < nStops; i++) {
				stops.add(new Station(readField(in), readField(in), readField(in)));
			}

			String startTime = readField(in);
			String endTime = readField(in);

			int km = in.readInt();
			int places = in.readInt();

			// .endsWith gets rid of package names
			if (className.endsWith("TrainExpress")) {
				int restaurantPlaces = in.readInt();
				t = new TrainExpress(start, end, startTime, endTime, places, km);
				((TrainExpress)t).setRestaurantPlaces(restaurantPlaces);
			} else {
				t = new Train(start, end, startTime, endTime, places, km);
			}
			
			t.setStops(stops);
			return t;
			
		} catch (EOFException e) {
			return null;
		}
	}

	private static String readField(DataInputStream in) throws IOException {
		// helper function to read a sequence of bytes and return a string
		byte[] buf = new byte[nChars];
		in.read(buf);
		return new String(buf).trim();
	}


}
