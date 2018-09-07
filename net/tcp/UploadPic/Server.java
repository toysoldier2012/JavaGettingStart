package net.tcp.UploadPic;

import java.io.*;
import java.net.*;

public class Server {
	ServerSocket ss;
	Socket s;
	ObjectInputStream socketOIS;
	BufferedInputStream socketBIS;
	BufferedWriter socketBW;

	File f = new File("123.jpg");
	File newFile;
	long timestramp;

	BufferedOutputStream fileBOS;

	byte[] temp;
	int tempArrayLength;

	private void InitServer() throws IOException, ClassNotFoundException {
		ss = new ServerSocket(10030);
		s = ss.accept();
		socketBIS = new BufferedInputStream(s.getInputStream());
		socketOIS = new ObjectInputStream(s.getInputStream());
		
		f = (File)socketOIS.readObject();
		newFile = new File("new-"+ f.getName());
		newFile.createNewFile();

		temp = new byte[1024];
		fileBOS = new BufferedOutputStream(new FileOutputStream(newFile));
		while ((tempArrayLength = socketBIS.read(temp)) != -1) {
			fileBOS.write(temp, 0, tempArrayLength);
			fileBOS.flush();
		}

		socketBW = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		socketBW.write("Got it\n");
		socketBW.flush();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new Server().InitServer();
	}
}
