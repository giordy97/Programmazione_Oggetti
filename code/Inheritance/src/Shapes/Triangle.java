package Shapes;

public class Triangle extends Shape {
	private double width, height;

	public Triangle(String name) {
		super(name);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSize() {
		return width * height / 2.0;
	}
	
	public double getPerimeter() {
		double x = Math.sqrt(Math.pow(width / 2.0, 2) + 
				Math.pow(height, 2));
		return width + 2 * x;
	}
	
}
