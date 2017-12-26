package BookStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Utils.DBManager;

public class BookStoreGUI extends JFrame implements ActionListener, TableModelListener {
	private static final long serialVersionUID = 1L;
	DBManager db;

	JTable tResults;
	JButton btInsert;
	JButton btDelete;
	JButton btLoad;
	JButton btQuit;

	public BookStoreGUI() {
		super();
		try {
			db = new DBManager();
			db.open();
			db.verify();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Open Database Failed\n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Open Database Failed\n" + e.getMessage());
		}
		
		tResults = new JTable();
		tResults.setGridColor(Color.BLACK);

		JPanel p01 = new JPanel();
		p01.setLayout(new GridLayout(2, 2));
		btInsert = new JButton("Insert...");
		btInsert.addActionListener(this);
		btDelete = new JButton("Delete");
		btDelete.addActionListener(this);
		
		btLoad = new JButton("Load");
		btLoad.addActionListener(this);
		btQuit = new JButton("Quit");
		btQuit.addActionListener(this);
		p01.add(btInsert);
		p01.add(btDelete);
		p01.add(btLoad);
		p01.add(btQuit);

		setLayout(new BorderLayout());
		add(p01, BorderLayout.SOUTH);
		add(new JScrollPane(tResults), BorderLayout.CENTER);

		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btLoad) {
			try {
				tResults.setModel(new BookTableModelUpdateable(db));
				tResults.getModel().addTableModelListener(this);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Loading Data Failed\n" + e1.getMessage());
			}
		} else if (e.getSource() == btQuit) {
			try {
				db.close();
			} catch (SQLException e1) {
				// do nothing
			}
			System.exit(0);
		} else if (e.getSource() == btInsert) {
			String[] book = JOptionPane.showInputDialog(this, "Insert Book (id;title;author;pages)").split(";");
			try {
				((BookTableModelUpdateable)tResults.getModel()).insertRow(book);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Inserting Data Failed\n" + e1.getMessage());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Inserting Data Failed\n" + e1.getMessage());
			}
		} else if (e.getSource() == btDelete) {
			try {
				((BookTableModelUpdateable)tResults.getModel()).removeRow(
						tResults.getSelectedRow(), tResults.getSelectedRow());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Deleting Data Failed\n" + e1.getMessage());
			}
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("The table has been modifed!");
	}
	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BookStoreGUI();
			}
		});
	}
}
