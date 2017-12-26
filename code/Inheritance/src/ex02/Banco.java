package ex02;
import java.util.Random;

public class Banco {
	private Random rnd;
	private int[] numeri_estratti;

	public Banco() {
		rnd = new Random();
		numeri_estratti = new int[90];
	}
	
	private boolean giaEstratto(int n) {
		if (numeri_estratti[n-1] == 1) {
			return true;
		}
		numeri_estratti[n-1] = 1;
		return false;
	}

	public int estraiNumero() {
		int n;
		do {
			n = rnd.nextInt(90) + 1;
		} while (giaEstratto(n));
		return n;
	}

}
