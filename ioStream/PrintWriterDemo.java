package ioStream;
import java.io.*;

class DisplayOnScreen {
	public static void display(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream ps = System.out;
		PrintWriter pw = new PrintWriter(ps);
		String s;

		while (!(s = br.readLine()).equals("over")) {
			pw.println(s);
			pw.flush();
		}
		br.close();
		pw.close();
	}
}

class LogRecord {
	public static void record(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintWriter pw = new PrintWriter(new FileWriter("PrintWriterDemoLog.txt"), true);
		String s;
		
		while(!"over".equals(s = br.readLine())) {
			pw.println(s);
		}
		br.close();
		pw.close();
		
	}
}

public class PrintWriterDemo {

	public static void main(String[] args) {
		InputStream is = System.in;

		try {
			//DisplayOnScreen.display(is);
			LogRecord.record(is);
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}

	}

}
