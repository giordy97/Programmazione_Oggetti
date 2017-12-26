package ex03;

import java.util.LinkedList;
import java.util.List;

public abstract class MyAbstractQueue<T> implements MyQueue<T> {
	List<T> tasks;
	
	public MyAbstractQueue() {
		tasks = new LinkedList<T>();
	}

	public void add(T t) {
		tasks.add(t);
	}
}
