package ex04_end;


import java.io.IOException;
import java.util.ArrayList;

public class TestApp {

	public static void main(String args[]) {
		ArrayList<Train> tList = new ArrayList<Train>();

		Train t;
		t = new TrainExpress(
				new Station("Milano", "MX1", "L1"), 
				new Station("Roma", "RM1", "L1"), 
				"11:0:00", 
				"14:12:00", 
				550, 
				600
				);

		t.addStop(new Station("Bologna", "BO1", "L1"));
		t.addStop(new Station("Firenze", "FR1", "L1"));
		t.addStop(new Station("Roma Tiburtina", "RM2", "L1"));
		tList.add(t);

		t = new Train(
				new Station("Milano", "MX1", "L1"), 
				new Station("Napoli", "NP1", "L1"), 
				"17:0:00", 
				"22:22:00", 
				450, 
				500
				);

		t.addStop(new Station("Bologna", "BO1", "L1"));
		t.addStop(new Station("Roma", "RM1", "L1"));
		tList.add(t);

		// prints trains which are going to be saved
		System.out.println("Trains to be stored:");
		for (Train tr: tList) {
			System.out.println(tr);
		}

		// test writes
		Storage st;
		try {
			st = new TextStorage("StorageText.dat");
			st.store(tList, false);
			System.out.println("TextStorage store OK! " + tList.size() + " trains stored.");

			st = new DataStorage("StorageData.dat");
			st.store(tList, false);
			System.out.println("DataStorage store OK! " + tList.size() + " trains stored.");

			st = new ObjectStorage("StorageObject.dat");
			st.store(tList, false);
			System.out.println("TextStorage store OK! " + tList.size() + " trains stored.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test reads
		try {
			st = new ObjectStorage("StorageObject.dat");
			tList = (ArrayList<Train>) st.load();
			System.out.println("\nObjectStorage load OK! " + tList.size() + " trains loaded.");
			for (Train tr: tList) {
				System.out.println(tr);
			}

			st = new TextStorage("StorageText.dat");
			tList = (ArrayList<Train>) st.load();
			System.out.println("\nTextStorage load OK! " + tList.size() + " trains loaded.");
			for (Train tr: tList) {
				System.out.println(tr);
			}

			st = new DataStorage("StorageData.dat");
			tList = (ArrayList<Train>) st.load();
			System.out.println("\nDataStorage load OK! " + tList.size() + " trains loaded.");
			for (Train tr: tList) {
				System.out.println(tr);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
