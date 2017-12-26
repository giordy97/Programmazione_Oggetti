package ex04_end;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStorage extends Storage {

	public ObjectStorage(String filename) {
		super(filename);
	}

	@Override
	public void store(List<Train> tList, boolean append) throws IOException {
		// http://java.sun.com/javase/technologies/core/basic/serializationFAQ.jsp#appendSerialStream
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.filename, false));
		for (Train t : tList) {
			out.writeObject(t);
		}
		out.close();
	}

	@Override
	public List<Train> load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename));
		List<Train> tList = new ArrayList<Train>();

		try {
			Object obj;
			while ((obj = in.readObject()) != null) {
				tList.add((Train)obj);
			}
		} catch (EOFException e) {
		} finally {
			in.close();
		}

		return tList;
	}
}
