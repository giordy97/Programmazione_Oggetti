package Examples;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;



public class JSONClientResource {
	ClientResource rs01;
	ClientResource rs02;
	JSONParser parser;
	
	public JSONClientResource() {
		rs01 = new ClientResource("http://localhost:8182/current_time"); 
		rs02 = new ClientResource("http://localhost:8182/current_date"); 
		parser = new JSONParser();
	}

	public void getTime() throws ResourceException, IOException, ParseException {
		String response = rs01.get().getText();
		System.out.println("[HTTP] " + response);

		JSONObject jobj = (JSONObject) parser.parse(response);
		System.out.println("[DECODED] second: " + jobj.get("second") + 
				" minute: " + jobj.get("minute") + 
				" hour: " + jobj.get("hour"));
	}

	public void getDate() throws ResourceException, IOException, ParseException {
		String response = rs02.get().getText();
		System.out.println("[HTTP] " + response);

		JSONObject jobj = (JSONObject) parser.parse(response);
		System.out.println("[DECODED] year: " + jobj.get("year") + 
				" month: " + jobj.get("month") +
				" day: " + jobj.get("day"));
	}


	public static void main(String[] args) throws ResourceException, IOException, InterruptedException, ParseException {
		JSONClientResource jc = new JSONClientResource();
		while (true) {
			jc.getTime();
			jc.getDate();
			Thread.sleep(5000);
		}

	}
}