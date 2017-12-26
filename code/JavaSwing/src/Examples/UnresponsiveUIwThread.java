package Examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnresponsiveUIwThread extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private boolean stop = false;
	private int countValue = 1;

	private JTextField tfCount;
	private JButton btnStart, btnStop;

	public UnresponsiveUIwThread() {
		super("Counter");
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		p1.add(new JLabel("Counter"));

		tfCount = new JTextField("" + countValue, 10);
		tfCount.setEditable(false);
		p1.add(tfCount);

		btnStart = new JButton("Start Counting");
		btnStart.addActionListener(this);
		p1.add(btnStart);

		btnStop = new JButton("Stop Counting");
		btnStop.addActionListener(this);
		p1.add(btnStop);

		add(p1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 120);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			stop = true;
		} else if (e.getSource() == btnStart) {
			stop = false;

			Thread t = new Thread() {
				public void run() {   // override the run(), to specify the running behaviors
					for (int i = 0; i < 1000000; i++) {
						if (stop) break;
						tfCount.setText("" + countValue);
						countValue++;
					}
				}
			};
			t.start();   

//			for (int i = 0; i < 1000000; i++) {
//				if (stop) break;
//				tfCount.setText("" + countValue);
//				countValue++;
//			}
		}
	}

	public static void main(String[] args) {
		new UnresponsiveUIwThread();
	}
}