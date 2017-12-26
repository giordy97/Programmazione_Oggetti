package BookStore;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import Utils.DBManager;

public class BookTableModelUpdateable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private DBManager db;
	private ResultSet books;

	private final String[] columnNames = new String[] {
			"Id", "Title", "Author", "Pages"
	};

	private final Class[] columnClass = new Class[] {
			Integer.class, String.class, String.class, Integer.class
	};

	public BookTableModelUpdateable(DBManager db) throws SQLException {
		this.db = db;
		books = db.executeQuery("SELECT * from book");
	}

	public void insertRow(Object[] data) throws NumberFormatException, SQLException {
		books.moveToInsertRow();
		books.updateInt("id", new Integer(((String)data[0])));
		books.updateString("title", (String)data[1]);
		books.updateString("author", (String)data[2]);
		books.updateInt("pages", new Integer(((String)data[3])));
		books.insertRow();
		fireTableRowsInserted(books.getRow(), books.getRow());
	}

	public void removeRow(int firstRow, int lastRow) throws SQLException {
		books.absolute(firstRow);
		for (int i=firstRow; i <= lastRow; i++) {
			books.deleteRow();
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
		int rowCount = 0;
		try {
			books.last();
			rowCount = books.getRow();
		} catch (SQLException e) {
			// do nothing
		}
		return rowCount;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			books.absolute(rowIndex + 1);
			switch (columnIndex) {
			case 0: return books.getInt("id");
			case 1: return books.getString("title");
			case 2: return books.getString("author");
			case 3: return books.getInt("pages");
			}
			throw new IllegalStateException("Unhandled column index: " + columnIndex);
		} catch (SQLException e) {
			// do nothing
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			books.absolute(rowIndex);
			switch (columnIndex) {
			case 0:
				books.updateInt("id", (Integer)aValue);
				break;
			case 1:
				books.updateString("title", (String)aValue);
				break;
			case 2:
				books.updateString("author", (String)aValue);
				break;
			case 3:
				books.updateInt("pages", (Integer)aValue);
				break;
			}
			fireTableCellUpdated(rowIndex, columnIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}