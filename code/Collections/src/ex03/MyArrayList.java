package ex03;

public class MyArrayList implements MyList {
	private static final int DEFAULT_CAPACITY = 16;
	private int size;     			
	private Object[] elements;

	public MyArrayList() {  
		elements = new Object[DEFAULT_CAPACITY];   
		size = 0;
	}

	public void add(Object data) {
		// re-allocate when array is full
		if (size >= elements.length - 1) {
			Object[] tmp = new Object[elements.length * 2];
			for (int i = 0; i < elements.length; i++) {
				tmp[i] = elements[i];
			}			
			elements = tmp;
		}	
		// add element
		elements[size] = data;
		size++;
	}

	public Object get(int index) {
		if (index < 0 || index >= size())
            return null;
		return elements[index];
	}

	public boolean remove(int index) {
		if (index < 0 || index >= size())
            return false;
		
		/// shift back elements in memory
		for (int i = index; i < size; i++) {
			elements[i] = elements[i+1];
		}
		
		size--;
		elements[size] = null;
		return true;
	}

	public int size() { 
		return size; 
	}
}

