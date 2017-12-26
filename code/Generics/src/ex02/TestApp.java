package ex02;

import java.util.ArrayList;

/**
 * Costruire una classe di utilità (Utils) composta da tre metodi statici
 * in grado di manipolare liste di elementi generici:
 * swap(List<E> l, int i, int j): scambia gli elementi agli indici i e j di posto (sulla lista l)
 * bubbleSort(List<E> l): esegue un ordinamento bubble sort sulla lista l
 * print(List<E> l): stampa tutti gli elementi della lista l
 * 
 * Il codice prodotto va applicato al seguente caso di studio
 * 
 * @author Nicola Bicocchi
 * 
 */
public class TestApp {
	public static void main(String[] args) {
		ArrayList<Double> l = new ArrayList<Double>();
		l.add(2.0);
		l.add(7.0);
		l.add(1.0);
		l.add(5.0);
		
		Utils.swap(l, 0, 3);
		Utils.print(l);
		
		Utils.bubbleSort(l);
		Utils.print(l);
		
		ArrayList<Student> s = new ArrayList<Student>();
		s.add(new Student("Nicola", "Bicocchi"));
		s.add(new Student("Lucia", "Rossi"));
		s.add(new Student("Maccio", "Capatonda"));
		
		Utils.print(s);
		Utils.bubbleSort(s);
		Utils.print(s);
	}
}
