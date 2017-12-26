package ex01;

/**
 * Una classe che rappresenta un Motorino
 * 
 * @author Nicola Bicocchi
 */
public class Motorino {
	String colore;
	String tipo;
	double velocità;
	boolean antifurto = false;
	
	
	/**
	 * @param colore 	Il colore del motorino 
	 * @param tipo		Il modello del motorino
	 * @param velocità	La velocità corrente del motorino
	 */
	public Motorino(String colore, String tipo, double velocità) {
		this.colore = colore;
		this.tipo = tipo;
		this.velocità = velocità;
	}
	
	/**
	 * @return 	la velocità corrente del motorino
	 */
	public double getVelocità() {
		return velocità;
	}
	
	/**
	 * @param incremento	incremento di velocità desiderato
	 */
	public void accelera(double incremento) {
		if (!antifurto) velocità += incremento;
	}
	
	public void inserisciAntifurto() {
		antifurto = true;
	}

	@Override
	public String toString() {
		return "Motorino [colore=" + colore + ", tipo=" + tipo + ", velocità=" + velocità + ", antifurto=" + antifurto
				+ "]";
	}
	
	

}
