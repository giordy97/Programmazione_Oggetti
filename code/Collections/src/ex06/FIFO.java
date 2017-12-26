package ex06;

public class FIFO extends MyAbstractQueue implements MyQueue {

	@Override
	public Task peek() {
		return tasks.get(0);
	}

	@Override
	public Task poll() {
		return tasks.remove(0);
	}
}
