package Examples;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

class KeyboardListenerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Color color = Color.BLACK;

	public KeyboardListenerPanel() {
		super();
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(color);
	}
}

public class KeyboardListener extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> lastChars;
	KeyboardListenerPanel panel;
	
   public KeyboardListener() {
	  lastChars = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
	  panel = new KeyboardListenerPanel();
	   
      Container cp = getContentPane();
      cp.add(panel);
      cp.setFocusable(true);
      cp.addKeyListener(this);
      
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setTitle("Testing Key Listener");
      this.setSize(300, 200);
      this.setVisible(true);
   }
   
   @Override
   public void keyTyped(KeyEvent e) {}
   
   @Override
   public void keyReleased(KeyEvent e) {}
   
   @Override
   public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      char keyChar = e.getKeyChar();
      System.out.println("keyPressed: VK Code is " + keyCode + ", Key char is " + keyChar);
      
      // update panel's color
      lastChars.add(0, keyCode);
      lastChars.remove(3);
      panel.setColor(new Color(lastChars.get(0), lastChars.get(1), lastChars.get(2)));
      repaint();
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new KeyboardListener();
         }
      });
   }
}
