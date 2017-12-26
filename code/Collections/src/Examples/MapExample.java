package Examples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		
		lhm.put("Silvia", 2);
		lhm.put("Marzia", 3);
		lhm.put("Silvia", 4);
		lhm.put("Nicola", 1);
		
		Map<String, Integer> hm = new HashMap<String, Integer>(lhm);
		Map<String, Integer> tm = new TreeMap<String, Integer>(lhm);
		
		// original list
		System.out.println(lhm);
		// no particular ordering
		System.out.println(hm);
		// natural ordering
		System.out.println(tm);
	}

}
