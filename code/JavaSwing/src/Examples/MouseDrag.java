package Examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MouseDrag extends JFrame {
	private static final long serialVersionUID = 1L;
	int startX, startY, endX, endY;  // a rectangle

	public MouseDrag() {
		DrawPanel drawPanel = new DrawPanel();
		MyListener listener = new MyListener();
		drawPanel.addMouseListener(listener);
		drawPanel.addMouseMotionListener(listener);
		
		getContentPane().add(drawPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 250);
		setTitle("Mouse Drag Test");
		setVisible(true);
	}

	private class MyListener extends MouseInputAdapter {
		@Override
		public void mousePressed(MouseEvent evt) {
			startX = evt.getX();
			startY = evt.getY();
		}
		@Override
		public void mouseDragged(MouseEvent evt) {
			endX = evt.getX();
			endY = evt.getY();
			repaint();  // callback paintComponent()
		}
		@Override
		public void mouseReleased(MouseEvent evt) {
			endX = evt.getX();
			endY = evt.getY();
			repaint();  // callback paintComponent()
		}
	}

	private class DrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);  // draw background
			g.setColor(Color.RED);
			g.drawRect(startX, startY, endX-startX+1, endY-startY+1);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MouseDrag();
			}
		});
	}
}