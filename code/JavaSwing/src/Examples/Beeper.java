package Examples;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Beeper extends JPanel implements ActionListener {

	private static final long serialVersionUID = 5775123950929476076L;
	public static void main(String[] args) {
		//Create and set up the window.
		JFrame frame = new JFrame("Beeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Beeper());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	JButton button;

	public Beeper() {
		super();
		button = new JButton("Click Me!");
		button.setPreferredSize(new Dimension(200, 80));
		button.addActionListener(this);
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
}