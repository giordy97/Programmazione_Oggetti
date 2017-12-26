package StudentManager;


import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class StudentPanel extends JPanel implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	//private static final String dateFormat = ;
	private JButton btnNext, btnPrev, btnDel, btnAdd;
	private JTextField txtName, txtSurname, txtID, txtBirthDate;
	private JSlider slider;
	private JLabel lblStatus;
	private StudentSubPanel subPanel;
	private StudentManager parent;

	private ArrayList<Student> students;
	private int curStudent; 
	private SimpleDateFormat df;

	public StudentPanel(StudentManager parent) {
		super();

		this.parent = parent; 
		df = new SimpleDateFormat("dd/MM/yyyy");
		students = new ArrayList<Student>();
		curStudent = 0;

		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnPrev = new JButton("Previous");
		btnPrev.addActionListener(this);
		btnDel = new JButton("Delete");
		btnDel.addActionListener(this);
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		txtName = new JTextField();
		txtSurname = new JTextField();
		txtID = new JTextField();
		txtBirthDate = new JTextField();

		lblStatus = new JLabel("Status: Empty Database");
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setEnabled(false);

		subPanel = new StudentSubPanel(this);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 4));
		p1.add(new JLabel("First Name: "));
		p1.add(txtName);
		p1.add(new JLabel("Last Name :"));
		p1.add(txtSurname);
		p1.add(new JLabel("ID: "));
		p1.add(txtID);
		p1.add(new JLabel("Birth Date :"));
		p1.add(txtBirthDate);

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

		setLayout(new GridLayout(4, 1));
		add(p1);
		add(subPanel);
		add(p2);
		add(p3);
	}

	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == btnAdd) {
			if (curStudent == students.size()) {
				// add button works only in this specific position 
				// i.e. the final empty record
				try {
					students.add(new Student(
							txtID.getText(),
							txtName.getText(),
							txtSurname.getText(),
							df.parse(txtBirthDate.getText())
							));
				} catch (ParseException ex) {
					Toolkit.getDefaultToolkit().beep();
				}			
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnDel) {
			try {
				students.remove(curStudent);
			} catch (IndexOutOfBoundsException ex) {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnPrev) {
			if (curStudent > 0) {
				curStudent--;
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}

		else if (e.getSource() == btnNext) {
			// here we allow an additional slot for new records
			if (curStudent < students.size()) {
				curStudent++;
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
		}
		updatePanel();
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			curStudent = slider.getValue();
			updatePanel();
		}
	}

	public void updatePanel() {
		subPanel.updatePanel();

		try {
			Student s = students.get(curStudent);
			txtName.setText(s.getName());
			txtSurname.setText(s.getSurname());
			txtID.setText(s.getID());
			txtBirthDate.setText(df.format(s.getBirthDate()));
		} catch (IndexOutOfBoundsException e) {
			// User is requesting a new record
			txtName.setText("");
			txtSurname.setText("");
			txtID.setText("");
			txtBirthDate.setText("");
		} finally {
			lblStatus.setText("Record: " + (curStudent + 1) + "/" + students.size());
			if (students.isEmpty()) {
				slider.setEnabled(false);
			} else {
				slider.setEnabled(true);
				slider.setMinimum(0);
				slider.setMaximum(students.size() - 1);
				slider.setMajorTickSpacing(students.size() / 10);
				slider.setValue(curStudent);				
			}
		}
	}

	public StudentManager getParent() {
		return parent;
	}

	public Student getCurrentStudent() {
		return students.get(curStudent);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
