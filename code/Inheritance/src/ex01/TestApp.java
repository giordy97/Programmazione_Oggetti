package ex01;



/**
 * Scrivere la classe Motorino che ha i seguenti attributi colore: una stringa
 * indicante il colore del motorino, velocità: un numero con la virgola indicante
 * la velocità in Km/h che possiede il motorino, tipo: una stringa indicante la
 * marca e il modello del motorino es. “Piaggio scarabeo”, l’attributo antifurto un
 * boolean che indica se è stato inserito l’antifurto (ha un valore iniziale pari a
 * false). Il costruttore ha come parametri una stringa per il colore, una stringa
 * per il tipo, un numero con la virgola per la velocità ed assegna opportunamente
 * i valori dei parametri agli attributi. Scrivere il metodo getVelocità che
 * restituisce la velocità del motorino, scrivere inoltre il metodo accelera che ha
 * come parametro un numero con la virgola indicante i Km/h che si vogliono
 * aggiungere alla velocità, il metodo verifica il valore dell’attributo antifurto
 * se è false aggiunge il valore del parametro all’attributo velocità, altrimenti
 * non fa nulla. Scrivere il metodo inserisciAntifurto che assegna un valore true
 * all’attributo antifurto. 
 * 
 * Scrivere la classe MotorinoImmatricolato sottoclasse
 * della classe Motorino che ha in più 2 attributi: maxVelocità un numero con la
 * virgola (coerente con la scelta fatta per l’attributo velocità) indicante la
 * velocità massima in Km/h che il motorino può raggiungere; targa una stringa
 * indicante la targa del motorino (ad entrambi gli attributi viene assegnato un
 * valore nel costruttore). Aggiungere il metodo getMax il metodo stampa il valore
 * dell’attributo maxVelocità. Ridefinire il metodo accelera in modo che prima di
 * modificare la velocità effettui un controllo sulla velocità massima raggiunta.
 * Il metodo definisce una variabile s (dello stesso tipo di velocità) ed assegna
 * ad s la somma tra il valore del parametro del metodo ed il valore dell’attributo
 * velocità; se s è minore del valore dell’attributo maxVelocità assegna il valore
 * di s all’attributo velocità altrimenti assegna all’attributo velocità il valore
 * dell’attributo maxVelocità. 
 * 
 * Le classi create vanno applicate al main sottostante
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Motorino m1 = new Motorino("Grigio", "Liberty", 40.5);
		MotorinoImmatricolato m2 = new MotorinoImmatricolato("Rosso", "Scarabeo", 30.5, "CV1234", 60.0);
		
		System.out.println(m1);
		System.out.println(m2);
		
		m1.accelera(40);
		m2.accelera(40);
		
		System.out.println(m1);
		System.out.println(m2);
	}

}
