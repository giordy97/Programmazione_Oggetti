package ex02;
import java.util.Scanner;

/**
 * Progettare un’applicazione che realizza il gioco della tombola
 * in una versione estremamente semplificata che coinvolge il banco 
 * e n giocatori. Assumiamo date due classi (banco e giocatore),
 * descritte qui di seguito:
 * 
 * Classe Banco:
 * Costruttore:
 *   Banco()
 *   // crea un nuovo banco
 * 
 * Metodi:
 *   int estraiNumero()
 *   // restituisce un numero pseudocasuale (java.util.Random)
 *   // nell’intervallo [1..90]
 *   
 * Classe Giocatore
 * Costruttore:
 *   Giocatore(String nome)
 *   // crea un giocatore, con il nome indicato
 *   // ed una scheda associata (un gruppo di 5 numeri)
 * Metodi:
 *   void controllaNumero(int x)
 *   // controlla se il numero x è contenuto nella scheda;
 *   // se si lo "marca" come estratto;
 *   boolean tombola()
 *   // restituisce true quando tutti i numeri della scheda sono marcati
 *   int[] verifica()
 *   // restituisce un array che contiene i numeri della scheda
 *   
 * Le classi create completano il main seguente
 *   
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static final int MAX_GIOCATORI = 4;

	public static void main(String[] args) {
		Banco b = new Banco();
		Giocatore[] g = new Giocatore[MAX_GIOCATORI];
		int estrazione = 0;
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < MAX_GIOCATORI; i++) {
			g[i] = new Giocatore(scanner.next());
		}
		scanner.close();

//		Versione semplificata
//		g[0] = new Giocatore("Luca");
//		g[1] = new Giocatore("Marco");
//		g[2] = new Giocatore("Matteo");
//		g[3] = new Giocatore("Giovanni");
		
		while(true) {
			estrazione++;
			int n = b.estraiNumero();
			System.out.println("Banco estrae: " + n);
			for (int i=0; i<MAX_GIOCATORI; i++) {
				g[i].controllaNumero(n);
				if (g[i].tombola()) {
					System.out.println("Vince in " + estrazione + " estrazioni: " + g[i]);
					System.exit(0);
				}
			}
		}
	}
}
