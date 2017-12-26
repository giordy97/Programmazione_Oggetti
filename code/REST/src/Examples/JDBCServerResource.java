package Examples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class JDBCServerResource extends ServerResource {  
	private final String DBConnectionString = "jdbc:sqlite:students.sqlite"; 
	private Statement stmt;
	
	public JDBCServerResource() {
		super();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(DBConnectionString);
			stmt = connection.createStatement();
			stmt.setQueryTimeout(30); 
		} catch (Exception ex) {
			System.out.println("Database connection failed");
		}
	}
	
	private void log_query() throws SQLException {
		String query = getReference().getPath();
		String q_log = "INSERT INTO \"log\" (\"query\") VALUES ('" + query + "');";
		System.out.println(q_log);
		stmt.executeUpdate(q_log);
	}
	
	private String resultset_to_json(ResultSet rs) throws SQLException {
		JSONArray jarr = new JSONArray();
		while (rs.next()){
			HashMap<String, String> row = new HashMap<String, String>();
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) 
				row.put(rs.getMetaData().getColumnName(i), String.valueOf(rs.getObject(i)));
			jarr.add(new JSONObject(row));
		}
		return jarr.toString();
	}
	
	public String getStudent_by_id() throws SQLException {
		String student_id = getQuery().getValues("student_id");
		String q = "SELECT * FROM students " +
				"WHERE student_id = " + "'" + student_id + "'" + " ORDER BY student_id";
		System.out.println(q);
		log_query();
		ResultSet rs = stmt.executeQuery(q);
		return resultset_to_json(rs);
	}
	
	public String getStudent_by_surname() throws SQLException {
		String surname = getQuery().getValues("surname");
		String q = "SELECT * FROM students " +
				"WHERE surname = " + "'" + surname + "'" + " ORDER BY name";
		System.out.println(q);
		log_query();
		ResultSet rs = stmt.executeQuery(q);
		return resultset_to_json(rs);
	}

	@Get  
	public String handleConnection() {  
		String response = null;
		try {
			if (getReference().getLastSegment().equals("get_student_by_id")) {
				// example: /1/get_student_by_id?student_id=1
				response = getStudent_by_id();
			} else if (getReference().getLastSegment().equals("get_student_by_surname")) {
				// example: /1/get_student_by_surname?surname=bicocchi
				response = getStudent_by_surname();
			} else {
				throw new ResourceException(new Status(Status.SERVER_ERROR_NOT_IMPLEMENTED, ""));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("OOOPPPPSSSS!!" + getReference());
		}
		return response;
	}

	public static void main(String[] args) throws Exception {  
		new Server(Protocol.HTTP, 8182, JDBCServerResource.class).start();  
	}

}  