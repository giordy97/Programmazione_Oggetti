package ex01;

/**
 * Costruire un classe (Utils) dotata di un unico metodo statico in grado di manipolare
 * numeri generici (vedi classe Number):
 * pow2(n) : ritorna il quadrato del valore immesso.
 * 
 * Il codice prodotto va applicato al seguente caso di studio
 * 
 * @author Nicola Bicocchi
 * 
 */
public class TestApp {
	public static void main(String[] args) {
		System.out.println(Utils.pow2(2));
		System.out.println(Utils.pow2(3.3));
		System.out.println(Utils.pow2(new Integer(4)));
		System.out.println(Utils.pow2(new Double(5.2)));
	}

}
