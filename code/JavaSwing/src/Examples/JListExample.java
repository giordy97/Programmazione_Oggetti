package Examples;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class JListExample extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JList<String> lstTest;
	JButton btnOK;

	public JListExample() {
		String[] data = {"one", "two", "three", "four"};
		lstTest = new JList<String>(data);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);

		setLayout(new BorderLayout());
		add(lstTest, BorderLayout.CENTER);
		add(btnOK, BorderLayout.PAGE_END);

		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new JListExample();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOK) {
			System.out.println(lstTest.getSelectedValue());
		}
	}

}
