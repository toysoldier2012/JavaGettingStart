package net.tcp.UploadFile;

import java.io.*;
import java.net.*;

public class Server {
	private ServerSocket ss;
	private Socket s;
	private BufferedReader socketBR;
	private PrintWriter socketPW;
	private String[] fileInfo;
	private String line;
	private File f;
	private PrintWriter filePW;

	public void InitServer() throws IOException {

		ss = new ServerSocket(10020);
		s = ss.accept();

		socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		fileInfo = socketBR.readLine().split(";");
		f = new File("new-" + fileInfo[1]);
		
		filePW = new PrintWriter(new FileWriter(f), true);
		
		while ((line = socketBR.readLine()) != null) {
			if (line.equals(fileInfo[0]))
				break;
			filePW.println(line);
		}
		
		socketPW = new PrintWriter(s.getOutputStream(), true);
		socketPW.println("Got it");
		
		ss.close();
		s.close();
		filePW.close();
	}

	public static void main(String[] args) throws IOException {
		new Server().InitServer();
	}

}
