package ioStream;
import java.io.*;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("BufferedWriterDemo.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		
		while((s = br.readLine()) != null) {
			System.out.println(s);
		}
		
		br.close();
	}

}
