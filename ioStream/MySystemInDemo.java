package ioStream;
import java.io.*;

class MySystemIn {
	private InputStream is = null;
	private OutputStream os = null;
	
	MySystemIn(InputStream is, OutputStream os) {
		this.is = is;
		this.os = os;
	}
	
//	public void systemIn() throws IOException {
//		StringBuilder s = new StringBuilder();
//		while(true) {
//			int ch = is.read();
//			if(ch == '\r')
//				continue;
//			if(ch == '\n') {
//				if("over".equals(s.toString()))
//					break;
//				System.out.println(s.toString());
//				s.delete(0, s.length());
//			} else s.append((char)ch);
//		}
//	}
	
	public void systemInOut() throws IOException{
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String s = null;
		
		while(!(s = br.readLine()).equals("over")) {
			bw.write(s);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
	
}

public class MySystemInDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		OutputStream os = System.out;
		MySystemIn msi = new MySystemIn(is,os);
		
		try {
			msi.systemInOut();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.toString());
		}
	}

}
