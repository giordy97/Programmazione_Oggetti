package Examples;
import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;



public class FirstClientResource {
	public static void main(String[] args) throws ResourceException, IOException {
		// Create the client resource  
		ClientResource resource = new ClientResource("http://localhost:8182");  

		// Write the response entity on the console
		resource.get().write(System.out);  
		
	}
}