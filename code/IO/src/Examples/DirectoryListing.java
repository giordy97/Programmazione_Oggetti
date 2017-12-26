package Examples;

import java.io.File;

/**
 * Class for listing the content of a directory
 * 
 * @author Nicola Bicocchi
 *
 */
public class DirectoryListing {   

	/**
	 * List a directory
	 * @param f			The directory to be explored
	 * @param recursive	True for recursive mode
	 */
	public void listDirectory(File f, boolean recursive) {
		if (!f.isDirectory()) return;
		File[] items = f.listFiles();
		
//		File[] items = f.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String file) {
//				return file.endsWith(".pdf");
//			}
//		});  

		for (File item : items) {
			System.out.println(item.getAbsoluteFile());
			if (recursive && item.isDirectory()) listDirectory(item, true); 
		}
	}

	public static void main(String[] args) {
		DirectoryListing dl = new DirectoryListing();
		dl.listDirectory(new File("/Users/nicola/Desktop/"), false);
	}

}