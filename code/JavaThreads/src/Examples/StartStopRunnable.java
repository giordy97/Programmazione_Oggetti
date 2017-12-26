package Examples;
class RunnableModule implements Runnable {
	public boolean running = true;

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		while (running) {
			System.out.println(Thread.currentThread().getName());	
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " terminated");
	}
}


public class StartStopRunnable {
	public static void main(String[] args) {
		RunnableModule r01 = new RunnableModule();
		RunnableModule r02 = new RunnableModule();
		
		Thread a = new Thread(r01, "Homer");
		Thread b = new Thread(r02, "Marge");
		
		a.setPriority(Thread.MIN_PRIORITY);
		b.setPriority(Thread.MIN_PRIORITY);

		a.start();
		b.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		r01.running = false;
		// Brutal mode!
		//a.interrupt(); 
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		r02.running = false;
		// Brutal mode!
		//b.interrupt();
		
	}
}
