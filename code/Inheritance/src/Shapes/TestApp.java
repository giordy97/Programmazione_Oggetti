package Shapes;

public class TestApp {
	public static void main(String[] args) {
		Shape[] shapes = {
				new Shape("Generic Shape"),
				new Triangle("Triangle"),
				new Square("Square"),
		};
		
		// Implicit UpCasting - Very useful! 
		// Only gives access through Shape interface!
		// Cannot call s.getPerimeter();
		for (Shape s : shapes) {
			s.showName();
		}
		
		Triangle t;
		// Explicit DownCasting - Very dangerous!
		// Might produce RUNTIME errors!
		t = (Triangle)shapes[0];
		t.setWidth(10);
		t.setHeight(10);
		t.getPerimeter();
		
		// Explicit DownCasting - Safer Version
		if (shapes[0] instanceof Triangle) {
			t = (Triangle)shapes[0];
			t.setWidth(10);
			t.setHeight(10);
			t.getPerimeter();
		}
		
		
	}

}
