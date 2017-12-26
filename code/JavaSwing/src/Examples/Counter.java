package Examples;
import java.awt.event.*;

import javax.swing.*;

public class Counter extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnInc;
	private JButton btnDec;
	private JLabel label;
	
	public Counter() {
		super();
		btnInc = new JButton("Inc");
		btnInc.setActionCommand("inc");
		btnInc.addActionListener(this);
		
		btnDec = new JButton("Dec");
		btnDec.setActionCommand("dec");
		btnDec.addActionListener(this);
		
		label = new JLabel();
		label.setText("0");
		add(btnInc);
		add(btnDec);
		add(label);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("inc")) {
			int n = Integer.parseInt(label.getText());
			n = n + 1;
			label.setText(Integer.toString(n));
		} else if (e.getActionCommand().equals("dec")) {
			int n = Integer.parseInt(label.getText());
			n = n - 1;
			label.setText(Integer.toString(n));
		}
	}
 
    public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("Beeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Counter());
 
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
