package Examples;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.sql.*;

public class TableToJTable{
	private Statement statement;

	public TableToJTable(Connection connection) throws ClassNotFoundException, SQLException {
		statement = connection.createStatement();
		statement.setQueryTimeout(30);  
	}

	/**
	 * This method return JTable object created from Database table having same data asn structure
	 * as in original table into database.
	 * @param table Name of the database table to be coverted to JTable
	 * @return JTable object that consist of data and structure of Database table
	 * @throws java.lang.Exception Original object is deferent, e.i either SQLException or NullPointerException
	 */
	public JTable getTable(String query) throws Exception{
		JTable t = new JTable();
		DefaultTableModel dm = new DefaultTableModel();
		
		ResultSet rs = statement.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		//Coding to get columns
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for(int i = 0; i < cols; i++){
			c[i] = rsmd.getColumnName(i+1);
			dm.addColumn(c[i]);
		}
		
		//Get data from rows
		Object row[] = new Object[cols];
		while(rs.next()){
			for(int i = 0; i < cols; i++){
				row[i] = rs.getString(i+1);
			}
			dm.addRow(row);
		}
		
		t.setModel(dm);
		t.setGridColor(Color.BLACK);
		
		return t;
	}

	public static void main(String ar[])throws Exception{
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:StudentManager.db");
		
		TableToJTable obj = new TableToJTable(connection);
		
		JFrame f = new JFrame("JTable Example");
		JScrollPane sp = new JScrollPane(obj.getTable("SELECT * FROM Students"));
		f.add(sp);
		f.setBounds(200,200,400,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);       
	}
}