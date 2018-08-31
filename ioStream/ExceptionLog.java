package ioStream;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionLog {

	public static void main(String[] args) {
		try {
			int[] i = new int[2];
			i[3] = 0;
		} catch(Exception e ) {
			FileOutputStream fos;
			PrintStream ps;
			try {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM-YYYY, HH:mm:ss");
				
				
				fos = new FileOutputStream("Exception.log");
				ps = new PrintStream(fos, true);
				ps.println(sdf.format(d).toString());
				System.setOut(ps);
			} catch (IOException e1) {
				throw new RuntimeException("Can't find the log file");
			}
			System.out.println(e.toString());
		}
	}

}
