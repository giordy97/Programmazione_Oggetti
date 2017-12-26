package ProducerConsumer;
import java.util.ArrayList;
import java.util.List;

class ProducerSynchronizedWN extends Thread {
	public static final int LIMIT = 4;
	public boolean running = true;
	private int count = 0;
	List<Integer> l;

	public ProducerSynchronizedWN(List<Integer> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			synchronized(l) {
				if (l.size() == LIMIT) {
					try {
						l.wait();
					} catch (InterruptedException e) {

					}
				} else {
					l.add(new Integer(count));
					System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + count++);
					l.notifyAll();
				}
			}
		}
	}
}

class ConsumerSynchcronizedWN extends Thread {
	public boolean running = true;
	List<Integer> l;

	public ConsumerSynchcronizedWN(List<Integer> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			synchronized(l) {
				if (l.size() == 0) {
					try {
						l.wait();
					} catch (InterruptedException e) {

					}
				} else {
					System.out.println("Consumer " + Thread.currentThread().getName() + " removed " + l.remove(0));
					l.notifyAll();
				}
			}
		}
	}
}


public class PCSynchronizedWN {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> l = new ArrayList<Integer>();

		ProducerSynchronizedWN p = new ProducerSynchronizedWN(l);
		ConsumerSynchcronizedWN c = new ConsumerSynchcronizedWN(l);

		p.start();
		c.start();

		Thread.sleep(100);

		c.running = false;
		p.running = false;
		
		p.join();
		c.join();
	}
}
