package ex03;

public class MyLinkedList implements MyList {
	private Node head;
	private int size;

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	public void add(Object data) {
		Node temp = new Node(data);

		if (head != null) {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
		} else {
			head = temp;
		}

		size++;
	}

	public Object get(int index) {
		if (index < 0) return null;

		Node current = head;
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

		Node current = head;
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


	private class Node {
		Node next;
		Object data;

		public Node(Object data) {
			this.next = null;
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}