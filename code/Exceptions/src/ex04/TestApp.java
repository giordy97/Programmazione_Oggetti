package ex04;

/**
 * Create a three-level hierarchy of exceptions. Now create a base-class A with a method 
 * that throws an exception at the base of your hierarchy. Inherit B from A and override 
 * the method so it throws an exception at level two of your hierarchy. Repeat by inheriting 
 * class C from B. In main( ), create a C and upcast it to A, then call the method.
 * What happens if A throws the most specific exception instead of the most general?
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		C item = new C();
		try {
			item.run();
		} catch (myException02 e) {
			e.printStackTrace();
		}
		
	}

}
