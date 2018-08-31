package ioStream;
import java.io.*;

class MyBufferedReader {
	private FileReader fr = null;
	
	MyBufferedReader(FileReader fr){
		this.fr = fr;
	}
	
	public String myReadLine() throws IOException {
		int num;
		char c;
		StringBuilder sb = new StringBuilder();
		
		while((num = fr.read()) != -1) {
			c = (char)num;
			if(c == '\r')
				continue;
			if(c == '\n')
				return sb.toString();
			sb.append(c);
		}
		
		return null;
	}
	
	public void close() throws IOException {
		fr.close();
	}
}

public class MyBufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("BufferedWriterDemo.txt");
		MyBufferedReader mbr = new MyBufferedReader(fr);
		
		String s;
		
		while((s = mbr.myReadLine()) != null) {
			System.out.println(s);
		}
		
		mbr.close();
	}
}