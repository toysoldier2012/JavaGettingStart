package ioStream;
import java.io.*;

class ReadFile {
	public static void readFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("RandomAccessFile.txt", "r");
		byte[] b = new byte[4];
		raf.seek(4 * 1);
		raf.skipBytes(4);
		raf.read(b);
		String name = new String(b);
		int age = raf.readInt();
		System.out.println(name +"-----"+ age);
		raf.close();
	}
}

class WriteFile {
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("RandomAccessFile.txt", "rw");
		raf.write("abcd".getBytes());
		raf.writeInt(12);
		raf.write("efgh".getBytes());
		raf.writeInt(13);
		raf.close();
	}
}

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriteFile.writeFile();
		ReadFile.readFile();
	}

}
