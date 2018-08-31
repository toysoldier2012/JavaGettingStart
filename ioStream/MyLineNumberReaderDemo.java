package ioStream;
import java.io.*;

class MyLineNumberReader{
	private FileReader fr = null;
	private int lineNumber = 0;
	
	MyLineNumberReader(FileReader fr){
		this.fr = fr;
	}
	
	
	public int getLineNumber() {
		return lineNumber;
	}


	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}


	public String readLine() throws IOException {
		int c = 0;
		StringBuilder sb = new StringBuilder();
		
		lineNumber++;
		while((c = fr.read()) != -1) {
			if(c == '\r')
				continue;
			if(c == '\n')
				return sb.toString();
			else
				sb.append((char)c);
		}
		return null;
	}
	
	public void close() {
		try {
			fr.close();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}
}

public class MyLineNumberReaderDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		MyLineNumberReader lnr = null;
		String s;
		
		try {
			fr = new FileReader("BufferedWriterDemo.txt");
			lnr = new MyLineNumberReader(fr);
			while((s = lnr.readLine()) != null)
				System.out.println(lnr.getLineNumber() +":"+ s);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Can't find the file!");
		} catch (IOException e) {
			throw new RuntimeException("IOException "+ e.toString());
		} finally {
			if(fr != null)
				lnr.close();
		}
	}
}
