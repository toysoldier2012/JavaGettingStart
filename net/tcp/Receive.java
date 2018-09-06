package net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receive implements Runnable {
	private Socket s;
	private BufferedReader socketBR;
	private String line = null;

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			socketBR = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (!(line = socketBR.readLine()).equals("over")) {
				System.out.println(line + "\n");
			}
			System.out.println(line +": "+ s.getLocalAddress());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socketBR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
