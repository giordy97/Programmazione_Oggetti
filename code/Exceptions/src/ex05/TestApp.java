package ex05;

import java.text.ParseException;

/**
 * Write a class capable of verifying that a String, passed as parameter, is composed
 * by letter followed by a number and so on. Use ParseException to notify the caller about
 * eventual errors.
 * 
 * Check your code with the following main.
 * @author Nicola Bicocchi
 *
 */
public class TestApp {

	public static void main(String[] args) {
		String s1 = "a6r6t8f0d0e";
		StringChecker sc = new StringChecker();
		try {
			sc.check(s1);
			System.out.println("Check succeeded!");
		} catch (ParseException e) {
			System.out.println("Check Failed!");
		}
	}

}
