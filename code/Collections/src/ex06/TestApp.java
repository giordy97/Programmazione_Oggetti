package ex06;

/**
 * Costruire, fruttando LinkedList, una classe FIFO, una classe LIFO, e una classe FIFOP. 
 * Le tre classi devono ospitare sequenze di azioni da campiere (Task) caratterizzati 
 * da un ID (String) e da una priorità (int). 
 * FIFO esegue la politica Fist In First Out, 
 * LIFO esegue Last in First Out, 
 * FIFOP ordina internamente I task per ritornare sempre quelli a priorità maggiore.
 * 
 * Le tre classi ritornano i loro oggetti interni attraverso due metodi:
 * peek() che ritorna un elemento senza eliminarlo dalla lista
 * poll() che ritorna un elemento eliminandolo dalla lista
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] x) {
		MyQueue q1 = new FIFOP();

		q1.add(new Task("T1", 5));
		q1.add(new Task("T2", 3));
		q1.add(new Task("T3", 6));

		System.out.println(q1.peek());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
	}


}
