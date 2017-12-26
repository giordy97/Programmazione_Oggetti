package ProducerConsumer;
import java.util.concurrent.ArrayBlockingQueue;

class ProducerV extends Thread {
	public boolean running = true;
	private int count = 0;
	ArrayBlockingQueue<Integer> l;

	public ProducerV(ArrayBlockingQueue<Integer> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			try {
				l.put(new Integer(count));
			} catch (InterruptedException e) {

			}
			System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + count++);
		}
		System.out.println("Produced " + count + " elements");
	}
}

class ConsumerV extends Thread {
	public boolean running = true;
	ArrayBlockingQueue<Integer> l;

	public ConsumerV(ArrayBlockingQueue<Integer> l) {
		this.l = l;
	}

	public void run() {
		while (running) {
			try {
				System.out.println("Consumer " + Thread.currentThread().getName() + " removed " + l.take());
			} catch (InterruptedException e) {

			}
		}
	}
}


public class PCArrayBlocking {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<Integer> l = new ArrayBlockingQueue<Integer>(4);

		ProducerV p = new ProducerV(l);
		ConsumerV c = new ConsumerV(l);

		p.start();
		c.start();

		Thread.sleep(100);

		c.running = false;
		p.running = false;
		
		p.join();
		c.join();

	}

}
