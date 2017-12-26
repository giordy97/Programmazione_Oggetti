package InternalImplementations;

public class TestADTs {
	public static void main(String[] args) {
		
		// MyArrayList
		MyList al = new MyArrayList();
		
		al.add("alpha");
		al.add("beta");
		
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		
		// MyLinkedList
		MyLinkedList ll = new MyLinkedList();
		
		ll.add("alpha");
		ll.add("beta");
		ll.add("delta");
		ll.add("omerga");
		
		System.out.println(ll.get(0));
		System.out.println(ll.get(1));
		
		// MyQueue
		MyQueue q = ll;
		
		System.out.println(q.getFirst());
		System.out.println(q.getLast());
		
		// MyHashMap
		MyHashMap m = new MyHashMap();
		m.put(11, 113);
		m.put(21, 112);
		m.put(33, 118);
		
		System.out.println(m.get(21));
		System.out.println(m);
	}
}
