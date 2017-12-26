package ProducerConsumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class ProducerVector<T> extends Thread {
	public static final int LIMIT = 4;
	public boolean running = true;
	private List<T> l;
	private int count = 0;

	public ProducerVector(List<T> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			if (l.size() < LIMIT) {
				l.add((T) new Integer(count));
				System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + count++);
			}
		}
	}
}

class ConsumerVector<T> extends Thread {
	public boolean running = true;
	private List<T> l;

	public ConsumerVector(List<T> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			if (l.size() > 0) {
				System.out.println("Comsumer " + Thread.currentThread().getName() + " consumed " + l.remove(0));
			}
		}
	}
}

public class PCVector {
	public static void main(String[] args) throws InterruptedException {
		// unsafe!
		// List<Integer> l = new LinkedList();
		
		// safe using Vector
		// List<Integer> l = new Vector<Integer>(); 
		
		// safe using Collections.synchronizedList
		List<Integer> l = Collections.synchronizedList(new LinkedList());
		
		ProducerVector<Integer> p = new ProducerVector<Integer>(l);
		ConsumerVector<Integer> c = new ConsumerVector<Integer>(l);

		p.start();
		c.start();

		Thread.sleep(100);

		c.running = false;
		p.running = false;

		p.join();
		c.join();
	}
}