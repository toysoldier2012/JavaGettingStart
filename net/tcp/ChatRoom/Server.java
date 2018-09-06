package net.tcp.ChatRoom;

import java.io.*;
import java.net.*;

public class Server {
	private ServerSocket ss;
	private Socket s;
	private BufferedReader socketBR;
	private BufferedWriter socketBW;
	
	Server(){
		InitServer();
	}
	
	public void InitServer() {
		try {
			ss = new ServerSocket(10010);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			s = ss.accept();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				ss.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				s.close();
				ss.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			socketBW = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				s.close();
				ss.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		String line = null;
		
		try {
			while((line = socketBR.readLine()) != null) {
				System.out.println(line);
				socketBW.write("Got it!");
				socketBW.newLine();
				socketBW.flush();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
