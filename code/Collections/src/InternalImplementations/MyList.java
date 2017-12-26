package InternalImplementations;

/**
 * Interface representing the basic operations of a list of objects
 * @author Nicola Bicocchi
 *
 */
public interface MyList {    
	public void add(Object data);
	public void add(Object data, int index);
	public Object get(int index);
	public boolean remove(int index);
	public int size();
	public String toString(); 
}

