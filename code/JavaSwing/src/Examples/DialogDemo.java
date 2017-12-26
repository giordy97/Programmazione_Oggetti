package Examples;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


class myDialog01 extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton button;

	public myDialog01() {
		super();
		
		button = new JButton("Temperature Warning!");
		button.addActionListener(this);
		add(button, BorderLayout.CENTER);
		
		setTitle("First Dialog!");
		setSize(200, 100);
	}

	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
}

class myDialog02 extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextArea txt;

	public myDialog02() {
		super();
		
		add(new JTextArea(), BorderLayout.CENTER);
		
		setTitle("Second Dialog!");
		setSize(200, 100);
	}

	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}
}

public class DialogDemo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btn01;
	private JButton btn02;

	public DialogDemo() {
		super("A JDialog Example");

		btn01 = new JButton("Open Dialog (first)");
		btn01.addActionListener(this);

		btn02 = new JButton("Open Dialog (second)");
		btn02.addActionListener(this);
		
		JPanel p01 = new JPanel();
		p01.add(btn01);
		p01.add(btn02);
		
		add(p01);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == this.btn01) {
			myDialog01 d = new myDialog01();
			d.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			d.setVisible(true);
		} else if (e.getSource() == this.btn02) {
			myDialog02 d = new myDialog02();
			d.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			d.setVisible(true);
		}
	}

	public static void main(String args[]) {
		new DialogDemo();
	}
}
