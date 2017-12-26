package ex04;

import java.util.GregorianCalendar;

/**
 * Nel contesto di un software per biblioteche, si implementi una classe Publication, 
 * che rappresenta una pubblicazione. Ciascuna pubblicazione ha un titolo e una data 
 * di uscita. Implementare le sottoclassi Book e Magazine. Un libro (book) ha anche 
 * un codice ISBN (numero intero di 13 cifre), mentre una rivista (magazine) ha un numero 
 * progressivo. Inoltre, una pubblicazione può fare riferimento ad altre pubblicazioni 
 * tramite riferimenti bibliografici. Implementare tutti i metodi necessari a rispettare il
 * seguente caso d’uso.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] x) {
		Publication libro = new Book("The Art of Unix Programming", new
				GregorianCalendar(1990, 3, 24), 123456);
		Publication rivista = new Magazine("Theoretical Computer Science", new
				GregorianCalendar(1985, 4, 13), 74);
		
		rivista.addReference(libro);
		
		System.out.println(rivista);
		for (Publication p : rivista.getReferences())
			System.out.println(p);
	}
}