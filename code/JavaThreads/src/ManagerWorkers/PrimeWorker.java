package ManagerWorkers;
import java.util.ArrayList;
import java.util.List;

class PrimeWorker implements Runnable {
	private PrimeProducer manager;
	private int start; 
	private int range;
	List<Integer> list;

	public PrimeWorker(PrimeProducer man, int start, int range) {
		this.manager = man;
		this.start = start;
		this.range = range;
		list = new ArrayList<Integer>();	
	}

	private boolean isPrime(int n) {
		if (n == 1) return true;
		int i = 2;
		while (n % i > 0) i++;
		if (i == n) return true;
		return false;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Analyzing range: " + start + " - " + (start + range) + "...");
		long startTime = System.nanoTime();
		
		for (int i = start; i < (start + range); i++) {
			if (isPrime(i)) list.add(i);
		}
		
		System.out.println(Thread.currentThread().getName() + ": Analyzed range: " + start + " - " + (start + range) + " in " +   
				(System.nanoTime() - startTime) / 1000000 + " msec.");

		/* Callback to PrimeProducer for sending results */
		manager.listen(Thread.currentThread(), list);
	}

}