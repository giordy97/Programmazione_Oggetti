package MovingSprite;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class DrawCanvas extends JPanel {
	private static final long serialVersionUID = 1L;
	Sprite sprite;
	
	public DrawCanvas(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		sprite.paint(g);
	}
}