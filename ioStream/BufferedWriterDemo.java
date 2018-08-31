package ioStream;
import java.io.*;

public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("BufferedWriterDemo.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i = 0; i < 5; i++) {
			bw.write("Hello Buffer! " + i);
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
	}
}
