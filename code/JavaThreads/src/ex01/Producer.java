package ex01;

import java.util.List;

class Producer extends AbstractObservable implements Runnable {
	public int wait;
	public boolean running = true;
	private int count = 0;
	private int limit;
	List<Integer> l;

	public Producer(int wait, List<Integer> l, int limit) {
		super();
		
		this.wait = wait;
		this.l = l;
		this.limit = limit;
	}

	public void run() {
		while (running) {
			
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e1) {
				// do nothing
			}

			synchronized(l) {
				if (l.size() == limit) {
					try {
						l.wait();
					} catch (InterruptedException e) {
						// do nothing
					}
				} else {
					l.add(new Integer(count));
					System.out.println("Producer " + Thread.currentThread().getName() + " pushed " + 
							count++ + " [speed=" + 1000/(double)wait + "int/sec]");
					l.notifyAll();
					
					// only for UI update
					notifyListeners(l.size());
					
				}
			}
		}

		System.out.println("Produced " + count + " elements");
	}
}