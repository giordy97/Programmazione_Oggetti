package Examples;
import java.sql.*;

import Utils.DBManager;

public class SupportedResultSetTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DBManager db = new DBManager();
		db.open();
		
		// Retrieve Metadata
		DatabaseMetaData md = db.getConnection().getMetaData();

		// Verify ResultSet's supported types
		System.out.println("-- ResultSet Type --");
		System.out.println("Supports TYPE_FORWARD_ONLY: "
				+ md.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
		System.out.println("Supports TYPE_SCROLL_INSENSITIVE: "
				+ md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
		System.out.println("Supports TYPE_SCROLL_SENSITIVE: "
				+ md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

		// Verify ResultSet's supported concurrency
		System.out.println("-- ResultSet Concurrency --");
		System.out.println("Supports CONCUR_READ_ONLY: "
				+ md.supportsResultSetType(ResultSet.CONCUR_READ_ONLY));
		System.out.println("Supports CONCUR_UPDATABLE: "
				+ md.supportsResultSetType(ResultSet.CONCUR_UPDATABLE));
		
		db.close();
	}
}