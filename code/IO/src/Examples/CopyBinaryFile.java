package Examples;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A class for copying binary files using InputStream and OutputStream interfaces
 * Different ways of copying are provided
 * 
 * @author Nicola Bicocchi
 *
 */
public class CopyBinaryFile {
	String inFileStr;
	String outFileStr;

	public CopyBinaryFile(String inFileStr, String outFileStr) {
		this.inFileStr = inFileStr;
		this.outFileStr = outFileStr;
	}

	/**
	 * Copy without any buffer
	 */
	public void copyNoBuffer() {
		FileInputStream in = null;
		FileOutputStream out = null;
		long startTime, elapsedTime; 
		int b;

		startTime = System.nanoTime();
		try {
			in = new FileInputStream(inFileStr);
			out = new FileOutputStream(outFileStr);

			while ((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			// always close the I/O streams
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("copyNoBuffer() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
	}

	/**
	 * Copy using a byte[] buffer
	 * @param bufferSize	The size of the buffer
	 */
	public void copyUserBuffer(int bufferSize) {
		FileInputStream in = null;
		FileOutputStream out = null;
		long startTime, elapsedTime;
		int n;
		byte[] byteBuf = new byte[bufferSize];    

		startTime = System.nanoTime();
		try {
			in = new FileInputStream(inFileStr);
			out = new FileOutputStream(outFileStr);

			while ((n = in.read(byteBuf)) != -1) {
				out.write(byteBuf, 0, n);
			}	
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			// always close the I/O streams
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("copyUserBuffer(" + bufferSize + ") [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");

	}

	/**
	 * Copy using BufferedInputStream and BufferedOutputStream
	 */
	public void copySystemBuffer() {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		long startTime, elapsedTime; 
		int b;

		startTime = System.nanoTime();
		try {
			in  = new BufferedInputStream(new FileInputStream(inFileStr));
			out = new BufferedOutputStream(new FileOutputStream(outFileStr));

			while ((b = in.read()) != -1) { 
				out.write(b);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// always close the I/O streams
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("copySystemBuffer() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
	}

	/**
	 * Copy using a large byte[] buffer containing the whole file
	 */
	public void copySinglePass() {
		FileInputStream in = null;
		FileOutputStream out = null;

		long startTime, elapsedTime; 
		long size = new File(inFileStr).length();
		byte[] buffer = new byte[(int)size];

		startTime = System.nanoTime();
		try {
			in  = new FileInputStream(inFileStr);
			out = new FileOutputStream(outFileStr);

			in.read(buffer);
			out.write(buffer);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// always close the I/O streams
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("copySinglePass() [" + new File(inFileStr).length() / (elapsedTime / 1000.0) + " MB/S]");
	}

	public static void main(String[] args) throws IOException {
		CopyBinaryFile cbf = new CopyBinaryFile("IMG.jpg", "IMG.jpg.bak");
		
		cbf.copyNoBuffer();
		cbf.copySystemBuffer();
		cbf.copySinglePass();
		for (int i = 0; i < 16; i++) cbf.copyUserBuffer((int)Math.pow(2, i));

	}
}