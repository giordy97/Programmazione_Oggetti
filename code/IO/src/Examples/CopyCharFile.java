package Examples;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A class for copying char(16bit!) files using Reader and Writer interfaces
 * Different ways of copying are provided
 * 
 * @author Nicola Bicocchi
 *
 */
public class CopyCharFile {
	String inFileStr;
	String outFileStr;

	public CopyCharFile(String inFileStr, String outFileStr) {
		this.inFileStr = inFileStr;
		this.outFileStr = outFileStr;
	}
	
	/**
	 * Copy without any buffer
	 */
    public void copyNoBuffer() throws IOException {
    	FileReader in = null;
    	FileWriter out = null;
    	long startTime, elapsedTime; 
    	int c;
    	
    	startTime = System.nanoTime();
        try {
            in = new FileReader(inFileStr);
            out = new FileWriter(outFileStr);

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
        elapsedTime = System.nanoTime() - startTime;
		System.out.println("copyNoBuffer() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
    }
    
	/**
	 * Copy using lines as a buffer
	 */
    public void copyLineBuffer() throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        long startTime, elapsedTime; 
        String line;
        
        startTime = System.nanoTime();
        try {
            in = new BufferedReader(new FileReader(inFileStr));
            out = new BufferedWriter(new FileWriter(outFileStr));

            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
        elapsedTime = System.nanoTime() - startTime;
		System.out.println("copyWithBuffer() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
    }
    
	/**
	 * Copy using BufferedReader and PrintWriter interfaces
	 */
    public void copyWithPrintBuffer() throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        long startTime, elapsedTime; 
        String line;

        startTime = System.nanoTime();
        try {
            in = new BufferedReader(new FileReader(inFileStr));
            out = new PrintWriter(new FileWriter(outFileStr));

            while ((line = in.readLine()) != null) {
                out.write(line);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
        elapsedTime = System.nanoTime() - startTime;
		System.out.println("copyWithPrintBuffer() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
    }
	
	public static void main(String[] args) throws IOException {
		CopyCharFile ccf = new CopyCharFile("webpage.html", "webpage.html.bak");
		
		ccf.copyNoBuffer();
		ccf.copyLineBuffer();
		ccf.copyWithPrintBuffer();
	}

}
