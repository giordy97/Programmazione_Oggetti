package ex02;

import java.util.List;

public class Utils {
	public static <T> void swap(List<T> l, int i, int j) {
		T c = l.get(i);
		l.set(i, l.get(j));
		l.set(j, c);
	}

	public static <T extends Comparable<T>> void bubbleSort(List<T> l) {
		boolean inOrder = false;
		while (!inOrder) {
			inOrder = true;
			for (int i = 1; i < l.size(); i++) {
				if(l.get(i - 1).compareTo(l.get(i)) > 0) {                
					inOrder = false;
					swap(l, i, i - 1);
				} 
			}
		}
	}
	
	public static <T> void print(List<T> l) {
		for (T e : l) {
			System.out.println(e);
		}
	}



}
