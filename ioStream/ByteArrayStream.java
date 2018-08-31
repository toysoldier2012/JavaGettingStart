package ioStream;
import java.io.*;

public class ByteArrayStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteArrayInputStream bais = new ByteArrayInputStream("ABCDEFG".getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int i = 0;
		
		while((i = bais.read()) != -1) {
			baos.write(i);
		}
		
		System.out.println(baos.size());
		System.out.println(baos.toString());
		System.out.println();
	}

}
