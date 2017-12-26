package Puzzle;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	private static final long serialVersionUID = 1L;
	private boolean isEmptyButton;
	private int x;
	private int y;

	public ImageButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		initUI();
	}

	public ImageButton(Image image, int x, int y) {
		super(new ImageIcon(image));
		this.x = x;
		this.y = y;
		initUI();
	}

	private void initUI() {
		isEmptyButton = false;
		BorderFactory.createLineBorder(Color.gray);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.yellow));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		});
	}

	public void setEmptyButton() {
		isEmptyButton = true;
	}

	public boolean isEmptyButton() {
		return isEmptyButton;
	}

	public Point getPoint() {
		return new Point(x, y);
	}
}
