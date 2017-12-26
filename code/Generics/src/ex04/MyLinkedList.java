package ex04;

public class MyLinkedList<T> {
	private Node<T> head;
	private int size;

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	public void add(T data) {
		Node<T> temp = new Node<T>(data);

		if (head != null) {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
		} else {
			head = temp;
		}

		size++;
	}

	public T get(int index) {
		if (index < 0) return null;

		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current.getData();
	}

	public boolean remove(int index) {
		if (index < 0 || index >= size())
			return false;

		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null)
				return false;
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		size--; 
		return true;
	}

	public int size() {
		return size;
	}


	private class Node<E> {
		Node<E> next;
		E data;

		public Node(E data) {
			this.next = null;
			this.data = data;
		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
}