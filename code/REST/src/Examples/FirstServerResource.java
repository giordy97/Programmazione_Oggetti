package Examples;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class FirstServerResource extends ServerResource {  

	@Get  
	public String handleConnection() {  
		return "hello, world!";  
	}

	public static void main(String[] args) throws Exception {  
		new Server(Protocol.HTTP, 8182, FirstServerResource.class).start();  
	}

}  