package ex02;

/**
 * Create your own exception class using the extends keyword. 
 * Write a constructor for this class that takes a String argument and stores 
 * it inside the object with a String reference. Write a method that prints out the stored String. 
 * Create a try-catch clause to exercise your new exception.
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {	
		try {
			throw new MyException("mmmhhh....");
		} catch (MyException e) {
			System.out.println(e.getMyString());
		}
	}
}
