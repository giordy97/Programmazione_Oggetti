package ex03;

import java.io.IOException;

/**
 * Scrivere una classe dotata di 4 metodi pubblici:
 * 1) getStudent che legge da tastiera i campi necessari 
 * (su una sola linea, separati da virgole) 
 * a descrivere uno studente (nome,cognome,anno imm.,media)
 * e ritorna un oggetto studente (vedi Scanner);
 * 2) storeText che accetta un riferimento a studente e 
 * un nome di file e salva sul file una rappresentazione
 * testuale dello studente (vedi BufferedWriter); 
 * 3) storeBinary che accetta un riferimento a studente e 
 * un nome di file e salva sul file una rappresentazione
 * binaria dello studente (vedi DataOutputStream);
 * 4) storeObject che accetta un riferimento a studente e 
 * un nome di file e salva sul file una rappresentazione serializzata
 * dello studente (vedi ObjectOutputStream);
 * 
 * La classe prodotta deve funzionare con il main sottostante.
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		Student s = sm.getStudent();
		
		try {
			sm.StoreBinary(s, "stud.bin");
			sm.StoreText(s, "stud.txt");
			sm.StoreObject(s, "stud.obj");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
