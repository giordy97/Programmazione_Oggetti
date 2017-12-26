package StudentManager;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class StudentSubPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 4883337201655579775L;
	private JButton btnAdd, btnRemove;
	private JList<Course> list;
	private JComboBox<Course> courses;
	private StudentPanel parent;

	private Student currentStudent;

	public StudentSubPanel(StudentPanel parent) {
		super();
		this.parent = parent;

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
		list = new JList<Course>(new DefaultListModel<Course>());
		courses = new JComboBox<Course>();

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 1));
		p1.add(courses);
		p1.add(btnAdd);
		p1.add(btnRemove);

		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridLayout(1, 2));
		add(p1);
		add(list);
	}

	public void updatePanel() {
		// here we update the combo box
		ArrayList<Course> cList = parent.getParent().getCoursesPanel().getCourses();
		courses.removeAllItems();
		for (Course c : cList) {
			courses.addItem(c);
		}

		// here we clear JList
		DefaultListModel<Course> lm = (DefaultListModel<Course>)list.getModel();
		lm.clear();

		// display student's data
		try {
			currentStudent = parent.getCurrentStudent();

			// here we populate JList
			ArrayList<Course> cs = currentStudent.getCourses();
			for (Course c : cs) {
				lm.addElement(c);
			}

			btnAdd.setEnabled(true);
			btnRemove.setEnabled(true);
		} catch (IndexOutOfBoundsException e) {
			btnAdd.setEnabled(false);
			btnRemove.setEnabled(false);
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAdd) {
			currentStudent.getCourses().add((Course)courses.getSelectedItem());
		} else if (e.getSource() == this.btnRemove) {
			
			// here we get the selected item
			int firstSelIdx = list.getSelectedIndex();
			Course selC = (Course)list.getModel().getElementAt(firstSelIdx);			

			// here we remove the course 
			ArrayList<Course> cs = currentStudent.getCourses();
			for (Iterator<Course> i = cs.iterator(); i.hasNext();) {
				Course c = i.next();
				if (c.getID() == selC.getID()) {
					i.remove();
				}
			}
		}
		updatePanel();
	}

}
