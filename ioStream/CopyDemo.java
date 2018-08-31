package ioStream;
/*
 * 
 */
import java.io.*;

public class CopyDemo {
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		
		char[] cbuf = new char[1024];
		int i = 0;
		
		try {
			fr = new FileReader("src\\FileWriterDemo.java");
			fw = new FileWriter("FileCopyDemo.java");
			while((i = fr.read(cbuf)) != -1)
				fw.write(new String(cbuf, 0, i));
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(fr != null)
					fr.close();
				if(fr != null)
					fw.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}
