package ex01;

public class MotorinoImmatricolato extends Motorino {
	String targa;
	double maxVelocità;
	
	public MotorinoImmatricolato(String colore, String tipo, double velocità, String targa, double maxVelocità) {
		super(colore, tipo, velocità);
		this.targa = targa;
		this.maxVelocità = maxVelocità;
	}

	public double getMax() {
		return maxVelocità;
	}

	@Override
	public void accelera(double incremento) {
		if (velocità + incremento > maxVelocità) {
			velocità = maxVelocità;
		} else {
			velocità += incremento;
		}
	}

	@Override
	public String toString() {
		return "MotorinoImmatricolato [targa=" + targa + ", maxVelocità=" + maxVelocità + ", colore=" + colore
				+ ", tipo=" + tipo + ", velocità=" + velocità + ", antifurto=" + antifurto + "]";
	}

}
