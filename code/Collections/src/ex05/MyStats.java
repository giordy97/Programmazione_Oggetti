package ex05;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for simple statistical calculations on integers
 * @author Nicola Bicocchi
 *
 */
public class MyStats {
	List<Integer> l;

	public MyStats() {
		l = new ArrayList<Integer>();
	}
	
	public void add(int n) {
		l.add(n);
	}
	
	public void add(Integer n) {
		l.add(n);
	}
	
	public double getMedia() {
		double sum = 0;
		for (int n : l) sum += n;
		return sum / l.size();
	}
	
	public double getMediana() {
	    int middle = l.size()/2;
	    if (l.size() % 2 == 1) {
	        return l.get(middle);
	    } else {
	        return (l.get(middle-1) + l.get(middle)) / 2.0;
	    }
	}
	
	public List<Integer> elems() {
		return l;
	}
	

}
