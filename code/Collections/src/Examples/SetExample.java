package Examples;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<String> lHashSet = new ArrayList<String>();
		ArrayList<String> lLinkedHashSet = new ArrayList<String>();
		ArrayList<String> lTreeSet = new ArrayList<String>();
		
		l.add("Nicola");
		l.add("Silvia");
		l.add("Marzia");
		l.add("Silvia");
		
		lHashSet.addAll(new HashSet<String>(l));
		lLinkedHashSet.addAll(new LinkedHashSet<String>(l));
		lTreeSet.addAll(new TreeSet<String>(l));
		
		// original list
		System.out.println(l);
		// initial ordering
		System.out.println(lLinkedHashSet);
		// no particular ordering
		System.out.println(lHashSet);
		// natural ordering
		System.out.println(lTreeSet);
	}

}
