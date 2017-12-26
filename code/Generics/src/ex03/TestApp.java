package ex03;

/**
 * Costruire, sfruttando LinkedList, una classe FIFO, una classe LIFO, e una classe FIFOP. 
 * Le tre classi devono ospitare oggetti generici.
 * FIFO esegue la politica Fist In First Out, 
 * LIFO esegue Last in First Out, 
 * FIFOP ordina internamente gli oggetti in base al loro ordinamento naturale (vedi Comparable).
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
		FIFOP<Product> q1 = new FIFOP<Product>();

		q1.add(new Product("Car"));
		q1.add(new Product("Ball"));
		q1.add(new Product("Spoon"));

		System.out.println(q1.peek());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
		System.out.println(q1.poll());
	}


}
