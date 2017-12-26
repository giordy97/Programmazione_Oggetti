package ex03;

public interface MyQueue<T> {
	public void add(T t);
	public T peek();
	public T poll();
}
