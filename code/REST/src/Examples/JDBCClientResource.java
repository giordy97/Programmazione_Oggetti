package Examples;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class JDBCClientResource {
	JSONParser parser;
	
	public JDBCClientResource() {
		parser = new JSONParser();
	}
	
	private String decodeStudent(String HTTPString) throws ParseException {
		String s = "";
		JSONArray jarr = (JSONArray) parser.parse(HTTPString);
		
		for (Object obj : jarr) {
			JSONObject jobj = (JSONObject) obj;
			s += "surname: " + jobj.get("surname") + 
					"; name: " + jobj.get("name") +
					"; average: " + jobj.get("average") +
					"; student_id: " + jobj.get("student_id");
		}
		return s;
	}

	public void getStudentID(String param) throws ResourceException, IOException, ParseException {
		ClientResource cr = new ClientResource("http://localhost:8182/1/get_student_by_id?student_id=" + param); 
		String response = cr.get().getText();
		System.out.println("[HTTP] " + response);
		System.out.println("[DECODED] " + decodeStudent(response));
	}
	
	public void getStudentSurname(String param) throws ResourceException, IOException, ParseException {
		ClientResource cr = new ClientResource("http://localhost:8182/1/get_student_by_surname?surname=" + param); 
		String response = cr.get().getText();
		System.out.println("[HTTP] " + response);
		System.out.println("[DECODED] " + decodeStudent(response));
	}


	public static void main(String[] args) throws ResourceException, IOException, InterruptedException, ParseException {
		JDBCClientResource jc = new JDBCClientResource();
		while (true) {
			jc.getStudentID("1");
			jc.getStudentSurname("bicocchi");
			Thread.sleep(5000);
		}

	}
}