package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Scrivere un programma Java che legga riga per riga un file di testo 
 * e generi un nuovo file contenente le due righe seguenti:
 * Numero righe lette: xx
 * Numero caratteri letti: yy
 * 
 * @author Nicola Bicocchi
 *
 */
public class TestApp{
	public static void main(String args[]) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		String s;
		int n_lines = 0, n_chars = 0;	
		
		try {
			in = new BufferedReader(new FileReader("/etc/passwd"));
			out = new BufferedWriter(new FileWriter("result.txt"));
			
			while ((s = in.readLine()) != null) {
				n_chars += s.length();
				n_lines++;
			}
			
			out.write("Numero righe lette: " + n_lines + '\n');
			out.write("Numero caratteri letti: " + n_chars + '\n'); 
			
		} catch (IOException e) {
			System.out.println("Errore di input/output: " + e);
		} finally {
			in.close();
			out.close();
		}
	}
}
