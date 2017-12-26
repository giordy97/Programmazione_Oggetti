package MovingSprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class Sprite models a moving game object, with its own operations
 *  and can paint itself.
 */
public class Sprite {
	public int x, y, r; 
	private BufferedImage image;

	public Sprite(String filename, int x, int y) {
		this.x = x;
		this.y = y;
		try {
			this.image = ImageIO.read(getClass().getResource(filename));
			if (image.getWidth() == image.getHeight()) {
				this.r = image.getWidth();	
			}
		} catch (IOException e) {
			this.image = null;
			this.r = 50;
		} catch (IllegalArgumentException e) {
			this.image = null;
			this.r = 50;
		}
	}

	/** Paint itself (given the Graphics context) */
	public void paint(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		} else {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, r, r);	
		}

	}
}
