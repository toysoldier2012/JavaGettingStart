package net.tcp.login;

import java.net.*;
import java.io.*;

public class Client{
	/*
	 * Normally, it should be encapsulated in two part(method): 
	 * one for type in username by user
	 * another one for send the information to server
	 * and i didn't handle the exceptions
	 */
	public void Init() throws UnknownHostException, IOException  {
		Socket s = new Socket("192.168.0.27",10040);
		PrintStream socketPS = new PrintStream(s.getOutputStream(), true);
		DataInputStream socketDIS = new DataInputStream(s.getInputStream());
		BufferedReader systemBR = new BufferedReader(new InputStreamReader(System.in));
		String username;
		Boolean flag;
		
		for(int i = 0; i < 3; i++){			
			System.out.println("Enter your username: ");
			username = systemBR.readLine();
			while(username.isEmpty()) {
				System.out.println("You must have a name!");
				username = systemBR.readLine();
			}
			socketPS.println(username);
			flag = socketDIS.readBoolean();

			if(!flag) {
				if(i < 2)
					System.out.println("try again!");
				else System.out.println("You shall not pass!");
			}
			else {
				System.out.println("Welcome!");
				break ;
			}
		}
		
		s.close();
		systemBR.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().Init();
	}
}
