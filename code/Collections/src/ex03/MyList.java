package ex03;

public interface MyList {  
	
	/**
	 * Adds an element to the list
	 * @param data
	 */
	public void add(Object data);
	
	/**
	 * Gets an element from the list
	 * @param index
	 * @return
	 */
	public Object get(int index);
	
	/**
	 * Remove an element from the list
	 * @param index
	 * @return
	 */
	public boolean remove(int index);
	
	/**
	 * Return the size of the list
	 * @return
	 */
	public int size();
}

