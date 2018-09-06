package net.tcp.ChatRoom;

import java.io.*;
import java.net.*;

public class Client{
	private Socket s;
	private BufferedReader socketBR;
	private BufferedWriter socketBW;
	private BufferedReader systemInBR;
	
	Client(){
		InitClient();
	}
	
	public void InitClient() {
		try {
			s = new Socket("192.168.0.20", 10010);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				s.close();
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
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		systemInBR = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		try {
			while((line = systemInBR.readLine()) != null) {
				if(line.equals("over"))
					break;
				socketBW.write(line);
				socketBW.newLine();
				socketBW.flush();
				System.out.println(socketBR.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
				systemInBR.close();				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Client();
	}
}

