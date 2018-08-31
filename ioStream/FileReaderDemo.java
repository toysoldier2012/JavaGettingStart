package ioStream;
/*
 * 
 */
import java.io.*;

public class FileReaderDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		int c = 0;
		char[] cbuf = new char[3];
		try {
			fr = new FileReader("src\\FileWriterDemo.java");
			
//			c = fr.read();
//			c = fr.read(cbuf);
//			while(c!=-1) {
//				for(int i = 0; i < c; i++)
//					System.out.print((char)cbuf[i]);					
//				c = fr.read(cbuf);
//			}
			
			while((c = fr.read(cbuf)) != -1)
					System.out.print(new String(cbuf, 0, c));
		
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(fr != null)
					fr.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}
