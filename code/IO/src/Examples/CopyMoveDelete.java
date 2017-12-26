package Examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyMoveDelete {
	public static void main(String[] args)  {		
		System.out.println("Copying...");
		try {
			Files.copy(new File("IMG.jpg").toPath(), 
					new File("IMG.jpg.bak").toPath(), 
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Copy failed!");
		}
		
		System.out.println("Moving...");
		try {
			Files.move(new File("IMG.jpg.bak").toPath(), 
					new File("IMG.jpg.bak2").toPath(), 
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Move failed!");
		}
		
		System.out.println("Deleting...");
		try {
			Files.delete(new File("IMG.jpg.bak2").toPath());
		} catch (IOException e) {
			System.out.println("Delete failed!");
		}
	}

}
