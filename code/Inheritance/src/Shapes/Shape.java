package Shapes;

public class Shape {
	protected String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	public void showName() {
		System.out.println(name);
	}
}
