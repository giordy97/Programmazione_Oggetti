package ex03;

public class FIFO<T> extends MyAbstractQueue<T> implements MyQueue<T> {

	@Override
	public T peek() {
		return tasks.get(0);
	}

	@Override
	public T poll() {
		return tasks.remove(0);
	}
}
