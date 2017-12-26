package ex02;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLReader {
	List<String> lastPage;
	String lastURL = null;
	
	public URLReader() {
		lastPage = new ArrayList<String>();
	}
	
    public void readPage(String urlname) throws IOException {
        URL url = new URL(urlname);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        lastURL = urlname;
        lastPage.clear();
        
        String line;
        while ((line = in.readLine()) != null)
        	lastPage.add(line);
        
        in.close();
    }
    
    public void savePage(String filename) throws IOException {
    	if (lastPage.isEmpty()) return;
    	PrintWriter out = new PrintWriter(new FileWriter(filename));
    	
    	for (String l : lastPage) {
    		out.println(l);
    	}
    	
    	out.close();
    }
}
