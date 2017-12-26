package Examples;
import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MovingWindow extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private JLabel pos;

    public MovingWindow() {
    	super("Moving Window");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        pos = new JLabel("");
        panel.add(pos, BorderLayout.SOUTH);
        
        this.add(panel);
        this.addComponentListener(this);

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void componentResized(ComponentEvent e) {
        int x = e.getComponent().getX();
        int y = e.getComponent().getY();
        int w = e.getComponent().getWidth();
        int h = e.getComponent().getHeight();
        pos.setText("x: " + x + " y: " + y + " w: " + w + " h: " + h);
    }

    public void componentMoved(ComponentEvent e) {
        int x = e.getComponent().getX();
        int y = e.getComponent().getY();
        int w = e.getComponent().getWidth();
        int h = e.getComponent().getHeight();
        pos.setText("x: " + x + " y: " + y + " w: " + w + " h: " + h);
    }

    public void componentShown(ComponentEvent e) {}

    public void componentHidden(ComponentEvent e) {}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MovingWindow ex = new MovingWindow();
                ex.setVisible(true);
            }
        });
    }
}