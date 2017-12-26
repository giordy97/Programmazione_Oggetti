package ex01;

public class Utils {
	public static <T extends Number> double pow2(T e) {
		return e.doubleValue() * e.doubleValue();
	}
}
