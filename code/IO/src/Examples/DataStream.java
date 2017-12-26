package Examples;
import java.io.*;

public class DataStream {
	String filename = "datastream.data";
	String message = "Hello World!";

	// Write primitives to an output file
	public void write() throws IOException {
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(filename)));

		out.writeByte(0);
		out.writeShort(65535);  // -1
		out.writeInt(0xABCD);
		out.writeLong(0x12344567);  // JDK 7 syntax
		out.writeFloat(11.22f);
		out.writeDouble(55.66);
		out.writeBoolean(true);
		out.writeBoolean(false);
		for (int i = 0; i < message.length(); i++) {
			out.writeChar(message.charAt(i));
		}
		out.writeChars(message);
		out.writeBytes(message);
		out.flush();
		out.close();
	}

	// Read raw bytes and print in Hex
	public void read_bytes() throws IOException {
		int inByte;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(filename));

		while ((inByte = in.read()) != -1) {
			System.out.printf("%02X ", inByte);   // Print Hex codes
		}
		System.out.printf("%n%n");
		in.close();
	}

	// Read primitives types
	public void read_primitive_types() throws IOException {

		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(filename)));

		System.out.println("byte:    " + in.readByte());
		System.out.println("short:   " + in.readShort());
		System.out.println("int:     " + in.readInt());
		System.out.println("long:    " + in.readLong());
		System.out.println("float:   " + in.readFloat());
		System.out.println("double:  " + in.readDouble());
		System.out.println("boolean: " + in.readBoolean());
		System.out.println("boolean: " + in.readBoolean());

		System.out.print("char:    ");
		for (int i = 0; i < message.length(); i++) {
			System.out.print(in.readChar());
		}
		System.out.println();

		System.out.print("chars:   ");
		for (int i = 0; i < message.length(); i++) {
			System.out.print(in.readChar());
		}
		System.out.println();

		System.out.print("bytes:   ");
		for (int i = 0; i < message.length(); i++) {
			System.out.print((char)in.readByte());
		}
		System.out.println();
		in.close();
	}

	public static void main(String[] args) {
		DataStream es = new DataStream();
		try {
			es.write();
			es.read_bytes();
			es.read_primitive_types();
		} catch (IOException e) {
			// IO Error
			e.printStackTrace();
		}
	}
}