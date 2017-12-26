package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static final String JDBCDriverSQLite = "org.sqlite.JDBC";
	public static final String JDBCURLSQLite = "jdbc:sqlite:bookstore.db";
	
	public static final String JDBCDriverMySQL = "com.mysql.jdbc.Driver";
	public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=episteme";
	
	protected Statement statement;
	protected Connection connection;
	
	public Statement getStatement() {
		return statement;
	}

	public Connection getConnection() {
		return connection;
	}

	/**
	 * Establishes the connection with DB
	 * ResultSet.TYPE_FORWARD_ONLY
	 * ResultSet.TYPE_SCROLL_INSENSITIVE
	 * ResultSet.TYPE_SCROLL_SENSITIVE
	 *
	 * ResultSet.CONCUR_READ_ONLY
	 * ResultSet.CONCUR_UPDATABLE
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void open() throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDriverMySQL);
		connection = DriverManager.getConnection(JDBCURLMySQL);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		statement.setQueryTimeout(30); 
	}

	public void verify() throws SQLException {
		try {
			statement.executeQuery("SELECT * FROM book LIMIT 1");
		} catch (SQLException e) {
			statement.executeUpdate("DROP TABLE IF EXISTS book");
			statement.executeUpdate("CREATE TABLE book (" +
					"id INTEGER PRIMARY KEY, " +
					"title VARCHAR(30), " +
					"author VARCHAR(30), " +
					"pages INTEGER)");
			statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(0, 'The Lord of the Rings', 'Tolkien', 241)");
			statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(1, 'Fight Club', 'Palahniuk', 212)");
			statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(2, 'Computer Networks', 'Tanenbaum', 313)");
			statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(3, 'Affective Computing', 'Picard', 127)");
		}
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return statement.executeQuery(query);
	}

	public int executeUpdate(String query) throws SQLException {
		return statement.executeUpdate(query);
	}

	public void close() throws SQLException {
		if (connection != null) {
			statement.close();
			connection.close();
		}
	}

}

