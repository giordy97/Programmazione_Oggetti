package StudentManager;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class CoursePanel extends JPanel implements ActionListener, ChangeListener {

	static final long serialVersionUID = 1L;
	static final String dateFormat = "dd/MM/yyyy";
	JButton btnNext, btnPrev, btnDel, btnAdd;
	JTextField txtName, txtTeachers, txtID, txtCredits;
	JSlider slider;
	JLabel lblStatus;
	JFrame app;

	ArrayList<Course> courses;
	int curCourse; 

	public CoursePanel(JFrame app) {
		super();

		this.app = app;
		courses = new ArrayList<Course>();
		curCourse = 0;

		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnPrev = new JButton("Previous");
		btnPrev.addActionListener(this);
		btnDel = new JButton("Delete");
		btnDel.addActionListener(this);
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		txtName = new JTextField();
		txtTeachers = new JTextField();
		txtID = new JTextField();
		txtCredits = new JTextField();

		lblStatus = new JLabel("Status: Empty Database");
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setEnabled(false);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 4));
		p1.add(new JLabel("ID: "));
		p1.add(txtID);
		p1.add(new JLabel("Description: "));
		p1.add(txtName);
		p1.add(new JLabel("N. Teachers :"));
		p1.add(txtTeachers);
		p1.add(new JLabel("Total Credits :"));
		p1.add(txtCredits);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 4));
		p2.add(btnPrev);
		p2.add(btnNext);
		p2.add(btnDel);
		p2.add(btnAdd);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		p3.add(lblStatus);
		p3.add(slider);

		setLayout(new GridLayout(3, 1));
		add(p1);
		add(p2);
		add(p3);
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == btnAdd) {
			if (curCourse == courses.size()) {
				// add button works only in this specific position 
				// i.e. the final empty record
				courses.add(new Course(
						txtID.getText(),
						txtName.getText(),
						Integer.parseInt(txtTeachers.getText()),
						Integer.parseInt(txtCredits.getText())
						));		
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnDel) {
			try {
				courses.remove(curCourse);
			} catch (IndexOutOfBoundsException ex) {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnPrev) {
			if (curCourse > 0) {
				curCourse--;
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnNext) {
			// here we allow an additional slot for new records
			if (curCourse < courses.size()) {
				curCourse++;
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}
		updatePanel();
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			curCourse = slider.getValue();
			updatePanel();
		}
	}

	public void updatePanel() {
		try {
			Course c = courses.get(curCourse);
			txtID.setText(c.getID());
			txtName.setText(c.getName());
			txtTeachers.setText(Integer.toString(c.getNteachers()));
			txtCredits.setText(Integer.toString(c.getTotalCredits()));
		} catch (IndexOutOfBoundsException e) {
			// User is requesting a new record
			txtName.setText("");
			txtTeachers.setText("");
			txtID.setText("");
			txtCredits.setText("");
		} finally {
			lblStatus.setText("Record: " + (curCourse + 1) + "/" + courses.size());
			if (courses.isEmpty()) {
				slider.setEnabled(false);
			} else {
				slider.setEnabled(true);
				slider.setMinimum(0);
				slider.setMaximum(courses.size() - 1);
				slider.setMajorTickSpacing(courses.size() / 10);
				slider.setValue(curCourse);				
			}
		}
	}
}
