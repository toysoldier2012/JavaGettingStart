package ioStream;
import java.io.*;

class Reader{
	public static void reader() throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream("DataStreamExercise.txt"));
		
		int i = dis.readInt();
		byte[] b = new byte[4];
		int length = dis.read(b);
		String s = new String(b, 0, length);
		String str = dis.readUTF();
		Boolean bo = dis.readBoolean();
		
		System.out.println(i);
		System.out.println(s);
		System.out.println(str);
		System.out.println(bo);
		
		dis.close();
	}
}

class Writer {
	public static void writer() throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("DataStreamExercise.txt"));
		
		int i = 4;
		String s = "abcd";
		Boolean bo = true;
		String str = "Äã";
		
		dos.writeInt(i);
		dos.writeBytes(s);
		dos.writeUTF(str);
		dos.writeBoolean(bo);
		
		dos.close();
	}
}

public class DataStreamExercise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Writer.writer();
		Reader.reader();
	}

}
