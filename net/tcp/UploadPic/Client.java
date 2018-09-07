package net.tcp.UploadPic;

import java.io.*;
import java.net.*;

public class Client {
	private Socket s;
	private BufferedReader socketBR;
	private ObjectOutputStream socketOOS;
	private BufferedOutputStream socketBOS;
	
	private File f;
	private BufferedInputStream fileBIS;
	
	private byte[] temp;
	private int tempArrayLength;
	
	private void InitClient() throws IOException {
		s = new Socket("192.168.0.27", 10030);
		socketBOS = new BufferedOutputStream(s.getOutputStream());
		socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		f = new File("123.jpg");
		socketOOS = new ObjectOutputStream(s.getOutputStream());
		socketOOS.writeObject(f);
		fileBIS = new BufferedInputStream(new FileInputStream(f));
		temp = new byte[1024];
		while((tempArrayLength = fileBIS.read(temp)) != -1) {
			socketBOS.write(temp, 0, tempArrayLength);
			socketBOS.flush();
		}
		
		s.shutdownOutput();
		
		System.out.println(socketBR.readLine());
		
		s.close();
		fileBIS.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Client().InitClient();
	}

}
