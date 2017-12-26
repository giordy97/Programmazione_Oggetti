package ex03;

/**
 * Create a class Test with two methods, f( ) and g( ). In g( ), throw an exception MyExcp01. 
 * In f( ), call g( ), catch its exception and, in the catch clause, 
 * throw an exception MyExcp02. 
 * Test your code in main( ).
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.f();
		} catch (myExcp02 e) {
			e.printStackTrace();
		}
	}
}
