package Examples;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class JSONServerResource extends ServerResource {  

	public String getDate() {
		JSONObject obj=new JSONObject();
		obj.put("machine", "pippo.frida.org");
		obj.put("year", Calendar.getInstance().get(Calendar.YEAR));
		obj.put("month", Calendar.getInstance().get(Calendar.MONTH));
		obj.put("day", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		return obj.toJSONString(); 
	}

	public String getTime() {
		JSONObject obj=new JSONObject();
		obj.put("machine", "pippo.frida.org");
		obj.put("second", Calendar.getInstance().get(Calendar.SECOND));
		obj.put("minute", Calendar.getInstance().get(Calendar.MINUTE));
		obj.put("hour", Calendar.getInstance().get(Calendar.HOUR));
		return obj.toJSONString(); 
	}

	@Get  
	public String handleConnection() {  
		String response = null;
		try {
			if (getReference().getLastSegment().equals("current_date")) {
				response = getDate();
			} else if (getReference().getLastSegment().equals("current_time")) {
				response = getTime();
			} else {
				throw new ResourceException(new Status(Status.SERVER_ERROR_NOT_IMPLEMENTED, ""));
			}
		} catch (Exception e) {
			System.out.println("OOOPPPPSSSS!!" + getReference());
		}
		return response;
	}

	public static void main(String[] args) throws Exception {  
		new Server(Protocol.HTTP, 8182, JSONServerResource.class).start();  
	}

}  