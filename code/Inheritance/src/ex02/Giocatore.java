package ex02;
import java.util.Random;

public class Giocatore {
	private String nome;
	private int[] scheda;
	private int[] scheda_estratti;
	private Random rnd;
	
	public static final int MAX_NUMBER = 5;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.scheda = new int[MAX_NUMBER];
		this.scheda_estratti = new int[MAX_NUMBER];
		this.rnd = new Random();
		riempiScheda();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private boolean inScheda(int n) {
		for (int i = 0; i < scheda.length; i++) {
			if (n == scheda[i]) {
				return true;
			}
		}
		return false;
	}
	
	private void riempiScheda() {
		int n;
		for (int i = 0; i < scheda.length; i++) {
			do {
				n = rnd.nextInt(90) + 1; 
			} while (inScheda(n));
			scheda[i] = n;
		}
	}
	
	public void controllaNumero(int n) {
		for (int i=0; i<scheda.length; i++) {
			if (scheda[i] == n) {
				scheda_estratti[i] = 1;
				break;
			}
		}
	}
	
	public boolean tombola() {
		for (int i=0; i<scheda_estratti.length; i++) {
			if (scheda_estratti[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int[] verifica() {
		return scheda;
	}
	
	public String toString() {
		String str = nome + " ";
		for (int i=0; i<MAX_NUMBER; i++) {
			if (scheda_estratti[i] == 1) {
				str += scheda[i] + "[*]-"; 
			} else {
				str += scheda[i] + "[ ]-"; 
				
			}
		}
		return str;
	}
}
