package StudentManager;


import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StudentManager extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 7625902767202484083L;
	private MenuBar menuBar;
	private Menu file;
	private MenuItem openFile; 
	private MenuItem saveFile; 
	private MenuItem close; 
	private StudentPanel pnStudents;
	private CoursePanel pnCourses;
	private JTabbedPane tabbedPane;

	public StudentManager() {
		super("Student Manager");
		menuBar = new MenuBar(); 
		file = new Menu("File"); 

		openFile = new MenuItem("Open"); 
		saveFile = new MenuItem("Save"); 
		close = new MenuItem("Close"); 

		pnCourses = new CoursePanel(this);
		pnStudents = new StudentPanel(this);
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Courses", pnCourses);
		tabbedPane.addTab("Students", pnStudents);
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		tabbedPane.addChangeListener(this);

		openFile.addActionListener(this); // add an action listener (so we know when it's been clicked
		openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false)); // set a keyboard shortcut
		file.add(openFile); // add it to the "File" menu

		saveFile.addActionListener(this);
		saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		file.add(saveFile);

		close.addActionListener(this);
		close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		file.add(close);

		menuBar.add(file);

		setMenuBar(menuBar);
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		getContentPane().add(tabbedPane);
	}

	public StudentPanel getStudentsPanel() {
		return pnStudents;
	}

	public CoursePanel getCoursesPanel() {
		return pnCourses;
	}

	public void actionPerformed (ActionEvent e) {
		// if the source of the event was our "close" option
		if (e.getSource() == this.close) {
			// dispose all resources and close the application
			this.dispose(); 
		} else if (e.getSource() == this.openFile) {
			JFileChooser open = new JFileChooser(); 
			int option = open.showOpenDialog(this); 
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					load(open.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} else if (e.getSource() == this.saveFile) {
			JFileChooser save = new JFileChooser(); 
			int option = save.showSaveDialog(this); 
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					save(save.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (SQLException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this.tabbedPane) {
			pnStudents.updatePanel();
			pnCourses.updatePanel();
		}
	}

	public void save(String filename) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
		Statement statement = connection.createStatement();

		// utility objects
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Formatter formatter; 

		try {
			statement.executeUpdate("DROP TABLE Students");
		} catch (SQLException e) {
			// do nothing
		}

		try {
			statement.executeUpdate("DROP TABLE Courses");
		} catch (SQLException e) {
			// do nothing
		}

		try {
			statement.executeUpdate("DROP TABLE StudentsCourses");
		} catch (SQLException e) {
			// do nothing
		}

		statement.executeUpdate("CREATE TABLE Students (StudentID TEXT(10) PRIMARY KEY, Name TEXT(50), Surname TEXT(50), Birthdate TEXT(10))");
		statement.executeUpdate("CREATE TABLE Courses (CourseID TEXT(10) PRIMARY KEY, Name TEXT(50), Teachers INTEGER, Credits INTEGER)");
		statement.executeUpdate("CREATE TABLE StudentsCourses (StudentID INTEGER NOT NULL, CourseID INTEGER NOT NULL, PRIMARY KEY (StudentID, CourseID), FOREIGN KEY (StudentID) REFERENCES Students (StudentID), FOREIGN KEY (CourseID) REFERENCES Courses (CourseID))");

		// insert courses
		for (Course c : pnCourses.getCourses()) {
			formatter = new Formatter(new StringBuilder());
			formatter.format("INSERT INTO Courses (CourseID, Name, Teachers, Credits) VALUES ('%s', '%s', '%d', '%d')", 
					c.getID(), c.getName(), c.getNteachers(), c.getTotalCredits());
			System.out.println(formatter.toString());
			statement.executeUpdate(formatter.toString());
		}

		// insert students
		for (Student s : pnStudents.getStudents()) {
			formatter = new Formatter(new StringBuilder());
			formatter.format("INSERT INTO Students (StudentID, Name, Surname, Birthdate) VALUES ('%s', '%s', '%s', '%s')", 
					s.getID(), s.getName(), s.getSurname(), df.format(s.getBirthDate()));
			System.out.println(formatter.toString());
			statement.executeUpdate(formatter.toString());

			// insert courses for each student
			for (Course c : s.getCourses()) {
				formatter = new Formatter(new StringBuilder());
				formatter.format("INSERT INTO StudentsCourses (StudentID, CourseID) VALUES ('%s', '%s')", 
						s.getID(), c.getID());
				System.out.println(formatter.toString());
				statement.executeUpdate(formatter.toString());
			}
		}
	}

	public void load(String filename) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
		Statement statement = connection.createStatement();
		ResultSet resultSet;

		// utility objects
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		resultSet = statement.executeQuery("SELECT Students.StudentID, Students.Name, Students.Surname, Students.Birthdate, Courses.CourseID, Courses.Name, Courses.Teachers, Courses.Credits FROM Students, StudentsCourses, Courses WHERE Students.StudentID = StudentsCourses.StudentID AND Courses.CourseID = StudentsCourses.CourseID");
		HashMap<String, Student> students = new HashMap<String, Student>();
		HashMap<String, Course> courses = new HashMap<String, Course>();
		while (resultSet.next()) {

			try {
				Student s = new Student(resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						df.parse(resultSet.getString(4)));

				Course c = new Course(resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getInt(8));

				if (!courses.containsKey(c.getID())) {
					courses.put(c.getID(), c);
				}

				if (!students.containsKey(s.getID())) {
					students.put(s.getID(), s);
				}
				
				students.get(s.getID()).getCourses().add(c);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		pnStudents.setStudents(new ArrayList<Student>(students.values()));
		pnCourses.setCourses(new ArrayList<Course>(courses.values()));

		pnStudents.updatePanel();
		pnCourses.updatePanel();
	}

	public static void main(String args[]) {
		StudentManager app = new StudentManager();
		app.setVisible(true);
	}

}
