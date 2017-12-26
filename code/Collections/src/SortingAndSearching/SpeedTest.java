package SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Class for showing the speed of insertion and retrieval 
 * from ArrayList, LinkedList, HashMap
 * @author Nicola Bicocchi
 *
 */
public class SpeedTest {
	int items;
	long start;
	long stop;
	Random rnd;
	
	public SpeedTest(int items) {
		this.items = items;
		this.rnd = new Random();
	}
	
	public long fillList(List<Integer> l) {
		start = System.nanoTime();
		for (int i = 0; i < items; i++) {
			
			// adding at the end or at the beginning 
			// makes a huge difference for arraylist
			// while it is irrelevant for linkedlist
			
			//l.add(rnd.nextInt(items));
			l.add(0, rnd.nextInt(items));
		}
		stop = System.nanoTime();
		return stop-start;
	}
	
	public void retrieveValueFromList(List<Integer> l, int value) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equals(value)) break;
		}
	}
	
	public long retrieveFromList(List<Integer> l) {
		start = System.nanoTime();
		for (int i = 0; i < items; i++) {
			retrieveValueFromList(l, rnd.nextInt(items));
		}
		stop = System.nanoTime();
		return stop-start;
	}
	
	public long fillMap(Map<Integer, Integer> m) {
		start = System.nanoTime();
		for (int i = 0; i < items; i++) {
			int n = rnd.nextInt(items);
			m.put(n, n);
		}
		stop = System.nanoTime();
		return stop-start;
	}
	
	public long retrieveFromMap(Map<Integer, Integer> m) {
		start = System.nanoTime();
		for (int i = 0; i < items; i++) {
			m.get(rnd.nextInt(items));
		}
		stop = System.nanoTime();
		return stop-start;
	}
	
	public static void main(String[] args) {
		long t;
		int items = 3000;
		SpeedTest test = new SpeedTest(items);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		t = test.fillList(al);
		System.out.println("Filling ArrayList [items=" + items + "][time=" + t/1000000.0 + "ms]");
		
		t = test.retrieveFromList(al);
		System.out.println("Retrieving ArrayList [items=" + items + "][time=" + t/1000000.0 + "ms]");
		
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		t = test.fillList(ll);
		System.out.println("Filling LinkedList [items=" + items + "][time=" + t/1000000.0 + "ms]");
		
		t = test.retrieveFromList(ll);
		System.out.println("Retrieving LinkedList [items=" + items + "][time=" + t/1000000.0 + "ms]");
		
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		t = test.fillMap(m);
		System.out.println("Filling HashMap [items=" + items + "][time=" + t/1000000.0 + "ms]");
		
		t = test.retrieveFromMap(m);
		System.out.println("Retrieving HashMap [items=" + items + "][time=" + t/1000000.0 + "ms]");
	}
}
