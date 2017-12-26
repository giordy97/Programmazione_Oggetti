package Examples;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CelsiusConverter extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton CFButton;
	private JButton FCButton;
	private JTextField fahrenheitTF;
	private JTextField celsiusTF;

	public CelsiusConverter() {
		super("Celsius Converter");
		celsiusTF = new JTextField("0");
		fahrenheitTF = new JTextField("32");
		CFButton = new JButton("°C->°F");
		CFButton.addActionListener(this);
		FCButton = new JButton("°F->°C");
		FCButton.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(celsiusTF);
		p1.add(new JLabel("°C"));
		p1.add(fahrenheitTF);
		p1.add(new JLabel("°F"));
		
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(CFButton);
		p2.add(FCButton);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);	
		add(p2, BorderLayout.SOUTH);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CFButton) {
			int tempFahr = (int)((Double.parseDouble(celsiusTF.getText())) * 1.8 + 32);
			fahrenheitTF.setText(Integer.toString(tempFahr));
			
			if (tempFahr < 32) {
		    JOptionPane.showMessageDialog(this,
		            "Water freezes here!",
		            "Temperrature Warning",
		            JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource() == FCButton) {
			int tempCelsius = (int)(((Double.parseDouble(fahrenheitTF.getText())) - 32) * 0.555);
			celsiusTF.setText(Integer.toString(tempCelsius));
			
			if (tempCelsius < 0) {
			    JOptionPane.showMessageDialog(this,
			    		"Water freezes here!",
			            "Temperrature Warning",
			            JOptionPane.WARNING_MESSAGE);
				}
		}
	}

	public static void main(String[] args) {
		new CelsiusConverter();
	}
}


