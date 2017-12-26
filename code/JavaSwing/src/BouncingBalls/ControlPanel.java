package BouncingBalls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ChangeListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private JCheckBox pause;
	private JCheckBox sounds;
	private JSlider slider;
	private JLabel fps;

	GamePanel gamePanel;
	Properties props;

	public ControlPanel(Properties props) {
		super();
		this.props = props;

		sounds = new JCheckBox("sounds");
		sounds.addActionListener(this);
		add(sounds);

		pause = new JCheckBox("pause");
		pause.addActionListener(this);
		add(pause);

		slider = new JSlider(10, 100);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		add(slider);
		
		// sync with received props
		sounds.setSelected(false);
		if (props.getProperty("sounds").equals("on")) sounds.setSelected(true);
		
		pause.setSelected(false);
		if (props.getProperty("pause").equals("on")) pause.setSelected(true);
		
		slider.setValue(Integer.parseInt(props.getProperty("fps")));
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (pause.isSelected()) {
			props.setProperty("pause", "on");
		} else {
			props.setProperty("pause", "off");
		}

		if (sounds.isSelected()) {
			props.setProperty("sounds", "on");
		} else {
			props.setProperty("sounds", "off");
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this.slider) {
			props.setProperty("fps", Integer.toString(slider.getValue()));
		}
	}

}
