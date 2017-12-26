package ex03;

import java.util.Collections;

public class FIFOP<T extends Comparable<T>> extends MyAbstractQueue<T> implements MyQueue<T> {
	
	public void add(T t) {
		tasks.add(t);
		Collections.reverse(tasks);
	}

	public T peek() {
		return tasks.get(tasks.size()-1);
	}

	public T poll() {
		return tasks.remove(tasks.size()-1);
	}

}
