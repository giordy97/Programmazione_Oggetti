package BookStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Utils.DBManager;

public class BookTableModel extends AbstractTableModel {
	private DBManager db;
	private ArrayList<Book> books;

	private final String[] columnNames = new String[] {
			"Id", "Title", "Author", "Pages"
	};

	private final Class[] columnClass = new Class[] {
			Integer.class, String.class, String.class, Integer.class
	};

	public BookTableModel(DBManager db) throws SQLException {
		this.db = db;
		books = new ArrayList<Book>();

		ResultSet rs = db.executeQuery("SELECT * from book");
		while (rs.next()) {
			books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
	}
	
	public void insertRow(Object[] data) throws NumberFormatException, SQLException {
		books.add(new Book(new Integer(((String)data[0])),
				(String)data[1],
				(String)data[2],
				new Integer(((String)data[3]))));
		db.executeUpdate(String.format(
				"INSERT INTO book (id, title, author, pages) VALUES(%d, '%s', '%s', %d)", 
				new Integer(((String)data[0])),
				(String)data[1],
				(String)data[2],
				new Integer(((String)data[3]))));
		fireTableRowsInserted(books.size(), books.size());
	}

	public void removeRow(int firstRow, int lastRow) throws SQLException {
		for (int i=firstRow; i <= lastRow; i++) {
			db.executeUpdate(String.format("DELETE FROM book WHERE id=%d", books.get(i).getId()));
			books.remove(i);
		}
		fireTableRowsDeleted(firstRow, lastRow);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book b = books.get(rowIndex);
		switch (columnIndex) {
		case 0: return b.getId();
		case 1: return b.getTitle();
		case 2: return b.getAuthor();
		case 3: return b.getPages();
		}
		throw new IllegalStateException("Unhandled column index: " + columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Book b = books.get(rowIndex);
		try {
			switch (columnIndex) {
			case 0:
				db.executeUpdate(String.format("UPDATE book SET id='%d' WHERE id=%d", aValue, b.getId()));
				b.setId((Integer)aValue);
				break;
			case 1:
				db.executeUpdate(String.format("UPDATE book SET title='%s' WHERE id=%d", aValue, b.getId()));
				b.setTitle((String)aValue);
				break;
			case 2:
				db.executeUpdate(String.format("UPDATE book SET author='%s' WHERE id=%d", aValue, b.getId()));
				b.setAuthor((String)aValue);
				break;
			case 3:
				db.executeUpdate(String.format("UPDATE book SET pages='%d' WHERE id=%d", aValue, b.getId()));
				b.setPages((Integer)aValue);
				break;
			}
			fireTableCellUpdated(rowIndex, columnIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}