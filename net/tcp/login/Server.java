package net.tcp.login;

import java.io.*;
import java.util.*;
import java.net.*;

class HandleUsernameThread implements Runnable {
	private Socket s;
	private HashSet<String> usernameList;
	HandleUsernameThread(Socket s, HashSet<String> usernameList){
		this.s = s;
		this.usernameList = usernameList;
	}

	public void run() {
		try {
			BufferedReader socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream socketDOS = new DataOutputStream(s.getOutputStream());
			
			String username;
			for(int i = 0; i < 3; i++) {
				username = socketBR.readLine();
				if(usernameList.contains(username)) {
					socketDOS.writeBoolean(true);
					System.out.println(s.getInetAddress().getHostAddress()+" "+ username +" log in");
					return ;
				} else {
					socketDOS.writeBoolean(false);
					System.out.println(s.getInetAddress().getHostAddress()+" "+ username +" try to login");	
					System.out.println("Times:"+ i);
				}
			}
			System.out.println(s.getInetAddress().getHostAddress()+" shall not pass!");
			
			s.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class ShutdownServerThread implements Runnable {
	private ServerSocket ss;
	private BufferedReader systemBR;
	private String shutDownServer = null;
	
	ShutdownServerThread(ServerSocket ss){
		this.ss = ss;
	}
	
	public void run() {
		systemBR = new BufferedReader(new InputStreamReader(System.in));
		try {
			shutDownServer = systemBR.readLine();
			systemBR.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(shutDownServer.equals("SHUTDOWNSERVER"))
			try {
				
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}

public class Server {
	public void Init() throws IOException {
		BufferedReader fileBR = new BufferedReader(new FileReader("usernameList.txt"));
		String username;
		HashSet<String> usernameList = new HashSet<>();
		while((username = fileBR.readLine()) != null)
			usernameList.add(username);
		fileBR.close();
		
		ServerSocket ss = new ServerSocket(10040);
		
		new Thread(new ShutdownServerThread(ss)).start();
		while(true) {
			Socket s = ss.accept();
			new Thread(new HandleUsernameThread(s, usernameList)).start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server().Init();
	}
}
