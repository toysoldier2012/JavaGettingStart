package ioStream;
/*
 * To dispose a simple thread of FileWriter
 */
import java.io.*;

public class FileWriterThreadDispose {
	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("f:\\FileWriterThreadDispose.txt");
			fw.write("Hello Thread!");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			//IMPORTANT
			try {
				//IMPORTANT
				if(fw != null)
					fw.close();
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
		}
	}
}
