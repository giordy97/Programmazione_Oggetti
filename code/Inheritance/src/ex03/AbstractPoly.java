package ex03;

public abstract class AbstractPoly implements Poly {

	@Override
	public boolean equals(Poly q) { 
		if (q == null || degree() != q.degree()) return false;

		boolean equal = true; 
		for (int i = 0; i <= degree() && equal; i++)
			equal = (coefficient(i) == q.coefficient(i));

		return equal;
	}
	
	@Override
	public String toString() { 
		if (degree() == 0) return ""+ coefficient(0);

		String out = (coefficient(0) == 0) ? "" : ""+ coefficient(0) + " + ";
		for (int i = 1; i < degree(); i++) {
			if (coefficient(i) != 0) 
				out += coefficient(i) + "x^" + i + " + ";
		}

		return out += coefficient(degree()) + "x^" + degree(); 
	}
}
