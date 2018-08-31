package ioStream;
/*
 * 
 */
import java.io.*;

public class BufferedCopyDemo {
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		String s = null;
		
		try {
			fr = new FileReader("src\\BufferedWriterDemo.java");
			br = new BufferedReader(fr);
			fw = new FileWriter("FileBufferedCopyDemo.java");
			bw = new BufferedWriter(fw);
			while((s = br.readLine()) != null) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if(br != null)
					br.close();
				if(br != null)
					bw.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}