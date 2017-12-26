package ex01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * Si sviluppi un’applicazione grafica che gestisce 
 * la velocità di esecuzione di due thread paralleli 
 * (produttore-­‐consumatore) che modificano una struttura dati 
 * condivisa (i.e., una lista di interi). I due componenti 
 * JSlider vengono utilizzati per modificare le rispettive 
 * velocità di produttore e consumatore, mentre il component 
 * JProgressBar mostra lo stato di riempimento della struttura 
 * dati condivisa (che deve essere limitata ad un valore 
 * prestabilito) Quando la struttura condivisa è piena il 
 * produttore deve arrestarsi, quando la struttura condivisa 
 * è vuota il consumatore deve arrestarsi.
 * @author Nicola Bicocchi
 *
 */
public class TestApp extends JFrame implements ChangeListener, SizeListener {
	private static final long serialVersionUID = 1L;
	protected JSlider speedProducer;
	protected JSlider speedConsumer;
	protected JProgressBar pb;
	protected List<Integer> l;
	protected Producer p;
	protected Consumer c;
	protected Thread tP;
	protected Thread tC;
	
	public static final int SIZE = 100;
	public static final int MIN_WAIT = 100;
	public static final int MAX_WAIT = 1000;
	public static final int INIT_WAIT = 100;
	
	
	public TestApp() {
		super("Producer-Consumer");
		
		/* secondary panel */
		speedProducer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
		speedProducer.setMajorTickSpacing(300);
		speedProducer.setPaintTicks(true);
		speedProducer.setPaintLabels(true);
		speedProducer.addChangeListener(this);
		
		speedConsumer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
		speedConsumer.setMajorTickSpacing(300);
		speedConsumer.setPaintTicks(true);
		speedConsumer.setPaintLabels(true);
		speedConsumer.addChangeListener(this);
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		panel.add(new JLabel("Producer wait period (ms)"));
		panel.add(new JLabel("Consumer wait period (ms)"));
		panel.add(speedProducer);
		panel.add(speedConsumer);
		
		/* producer and consumer */
		l = new ArrayList<Integer>();
		for (int i = 0; i < SIZE/2; i++) l.add(i);
				
		p = new Producer(INIT_WAIT, l, SIZE);
		p.addListener(this);
		c = new Consumer(INIT_WAIT, l);
		c.addListener(this);
		
		tP = new Thread(p);
		tC = new Thread(c);
		tP.start();
		tC.start();
		
		/* main panel */
		pb = new JProgressBar(0, SIZE);
		setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(pb, BorderLayout.SOUTH);
		
		pack();            
		setVisible(true);    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == speedProducer) {
			p.wait = speedProducer.getValue();
		}
		
		if (e.getSource() == speedConsumer) {
			c.wait = speedConsumer.getValue();
		}	
	}
	
	@Override
	public void sizeChanged(int size) {
		pb.setValue(size);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TestApp(); 
			}
		});
	}


}
