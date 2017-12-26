package ex05;

import java.text.ParseException;

/**
 * Class for checking that a string is composed by a letter followed by a number and so on
 * @author Nicola Bicocchi
 *
 */
public class StringChecker {
	public void check(String s) throws ParseException {
		boolean waitingLetter = true;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (Character.isDigit(c) && (waitingLetter == true)) {
				throw new ParseException(s, i);
			}
			if (Character.isLetter(c) && (waitingLetter == false)) {
				throw new ParseException(s, i);
			}
			waitingLetter = !waitingLetter;
		}
	}
}
