package ex03;

public class ArrayPoly extends AbstractPoly implements Poly { 
	/** 
	 * rappresentazione: array dei coefficienti 
	 * invariante: 
	 *  coeffs = l'array contiene tutti i coefficienti del polinomio 
	 *           organizzati in modo che coeff[i] e` il coefficiente
	 *           del momonio di esponente i. 
	 *  Il polinomio nullo ha un solo coefficiente, coeff[0] = 0.0;
	 */

	private double[] coeffs; 

	/** 
	 * @param coeffs e` l'array dei coefficienti. Se coeffs != null, 
	 *        coeffs.length = grado del polinomio + 1. 
	 * Costruisce il ListPoly con coefficienti coeffs. Se coeffs == null,
	 * costruisce il polinomio nullo, rappresentato dalla costante 0
	 */        
	public ArrayPoly(double[] coeffs) { 
		if (coeffs == null || coeffs.length == 0) {
			return;
		}

		this.coeffs = new double[coeffs.length];
		for (int i = 0; i < coeffs.length; i++) 
			this.coeffs[i] = coeffs[i];
	}

	@Override
	public int degree() { 
		return coeffs.length - 1;
	}

	@Override
	public Poly derivative() { 
		double[] cs = new double[Math.max(1,coeffs.length - 1)];

		for (int i = 1; i < coeffs.length; i++) 
			cs[i-1] = i * coeffs[i];

		return new ArrayPoly(cs);
	}

	@Override
	public double coefficient(int degree) { 
		if (degree > degree() || degree < 0) return 0.0;
		else return coeffs[degree];
	}

}
