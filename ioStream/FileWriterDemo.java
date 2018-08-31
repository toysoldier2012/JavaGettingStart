package ioStream;
/*
 * A simple demo about FileWriter 
 */

import java.io.*;

public class FileWriterDemo {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = null;
		try {
			//fw = new FileWriter("f:\\FileWriterThreadDispose.txt");
			fw = new FileWriter("FileWriterDemo.txt",true);
			fw.write("\nHello Thread!");
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
