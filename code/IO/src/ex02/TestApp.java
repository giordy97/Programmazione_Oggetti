package ex02;

import java.io.IOException;

/**
 * La classe Java URL contiene un metodo openStream() che ritorna un InputStream
 * collegato alla pagina indicata al costruttore di URL. 
 * Ad esempio new URL("http://www.google.it").openStream() ritorna un InputStream.
 * 
 * Costruire una classe URLReader che funzioni con il main sottostante in grado
 * di leggere una pagina web, memorizzarla, ed eventualmente salvarla su un file di testo.
 * 
 * Per utilizzare BufferedReader (stream di testo) con dati provenienti da 
 * un InputStream (stream binario) utilizzare la classe InputStreamReader per effettuare
 * la conversione.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		URLReader ur = new URLReader();
		try {
			System.out.println("Downloading page...");
			ur.readPage("http://www.google.it");
			
			System.out.println("Saving page...");
			ur.savePage("lastPage.html");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with I/O...");
		}
		
	}
}
