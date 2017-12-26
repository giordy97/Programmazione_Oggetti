package Examples;
import java.io.*;
public class CommandExecution {

	public static void main(String args[]) {
		try {
			String line;
			Process p = Runtime.getRuntime().exec("/bin/ls -al /");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		}
		catch (Exception err) {
			err.printStackTrace();
		}
	}
}