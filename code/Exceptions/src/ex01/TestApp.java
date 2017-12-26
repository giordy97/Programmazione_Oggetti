package ex01;

/**
 * Create a class with a main( ) that throws an object of class Exception inside a try block. 
 * Give the constructor for Exception a String argument. Catch the exception inside a catch 
 * clause and print the String argument. Add a finally clause and print a message to prove 
 * you were there.
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		try {
			throw new Exception("Problem detected!");
		} catch (Exception e) {
			// we do nothing
		} finally {
			System.out.println("Inside finally block...");
		}
	}

}
