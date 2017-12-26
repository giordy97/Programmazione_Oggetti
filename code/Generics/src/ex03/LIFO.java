package ex03;

public class LIFO<T> extends MyAbstractQueue<T> implements MyQueue<T> {

	@Override
	public T peek() {
		return tasks.get(tasks.size()-1);
	}

	@Override
	public T poll() {
		return tasks.remove(tasks.size()-1);
	}
}
