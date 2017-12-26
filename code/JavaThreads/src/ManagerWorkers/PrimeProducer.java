package ManagerWorkers;
import java.util.List;

public class PrimeProducer implements Runnable {
	public boolean running = true;
	private int start, stop, blocksize, nthreads;
	private Thread[] threads;
	
	public PrimeProducer(int start, int stop, int blocksize, int nthreads) {
		this.start = start;
		this.stop = stop;
		this.blocksize = blocksize;
		this.nthreads = nthreads;
	}

	public void run() {
		threads = new Thread[nthreads];
		for (int i = 0; i < nthreads; i++) {
			threads[i] = new Thread(new PrimeWorker(this, start + 1, blocksize - 1));
			threads[i].start();
			start += blocksize;
		}
	}

	/* Synchronized callback function called by Workers */
	public synchronized void listen(Thread t, List<Integer> l) {
		System.out.println("Manager: Received results from thread " + t.getName() + ".");
		
		/* Eventually start a new worker, replacing the finished one */
		if ((start < stop) && (running)) {
			for (int i = 0; i < nthreads; i++) {
				if (threads[i] == t) {
					threads[i] = new Thread(new PrimeWorker(this, start + 1, blocksize - 1));
					threads[i].start();
					start += blocksize;
				} 
			}
		}
	}
}
