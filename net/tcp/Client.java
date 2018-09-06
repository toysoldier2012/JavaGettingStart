package net.tcp;

import java.io.*;
import java.net.*;

class Client{
	private Socket s;
	
	public void initClient(){
		try {
			s = new Socket("192.168.0.20", 10010);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Receive rece = new Receive();
		Send send = new Send();
		
		rece.setS(s);
		send.setS(s);
		
		Thread t1 = new Thread(rece);
		Thread t2 = new Thread(send);
		
		t1.start();
		t2.start();
		
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

