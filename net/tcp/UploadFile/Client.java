package net.tcp.UploadFile;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	private Socket s;
	private File f;
	private Long timestramp;
	private BufferedReader fileBR;
	private PrintWriter socketPW;
	private BufferedReader socketBR;
	private String line;

	public void InitClient() throws IOException {
		s = new Socket("192.168.0.27", 10020);
		
		f = new File("test.txt");
		timestramp = new Date().getTime();
		socketPW = new PrintWriter(s.getOutputStream(), true);
		socketPW.println(String.valueOf(timestramp) + ";" + f.getName());
		

		fileBR = new BufferedReader(new FileReader(f));
		
		while ((line = fileBR.readLine()) != null) {
			socketPW.println(line);
		}
		
		socketPW.println(String.valueOf(timestramp));
		
		socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(socketBR.readLine());
		
		s.close();
		fileBR.close();
	}

	public static void main(String[] args) {
		try {
			new Client().InitClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
