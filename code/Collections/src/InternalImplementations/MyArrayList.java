package InternalImplementations;

/**
 * Implementation of MyList interface using an internal array
 * @author Nicola Bicocchi
 *
 */
public class MyArrayList implements MyList {
	private static final int DEFAULT_CAPACITY = 8;
	private int size;     			
	private Object[] elements;

	public MyArrayList() {  
		// allocate default initial capacity
		elements = new Object[DEFAULT_CAPACITY];   
		size = 0;
	}

	public MyArrayList(int capacity) {    
		elements = new Object[capacity];  
		size = 0;
	}

	public void add(Object data) {
		// we re-allocate before complete fullness
		if (size >= elements.length - 1) {
			// buffer re-allocation
			Object[] tmp = new Object[elements.length * 2];
			for (int i = 0; i < elements.length; i++) {
				tmp[i] = elements[i];
			}			
			elements = tmp;
		}	
		elements[size] = data;
		size++;
	}

	public void add(Object data, int index) {
		add(data);
		/* move array elements into memory */
		for (int i = elements.length - 1; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = data;
		elements[size] = null;
	}

	public Object get(int index) {
		if (index < 0 || index >= size())
            return null;
		return elements[index];
	}

	public boolean remove(int index) {
		if (index < 0 || index >= size())
            return false;
		/* move array elements into memory */
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

	public String toString() {
		String output = "";
		for (Object o : elements) {
			if (o != null) {
				output += "[" + o.toString() + "]";
			}
		}
		return output;
	}
}

