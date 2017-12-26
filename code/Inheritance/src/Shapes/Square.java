package Shapes;

public class Square extends Shape {
	private double edge;

	public Square(String name) {
		super(name);
	}
	
	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	public double getSize() {
		return edge * edge;
	}
	
	public double getPerimeter() {
		return edge * 4;
	}

}
