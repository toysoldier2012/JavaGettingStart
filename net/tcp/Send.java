package net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Send implements Runnable {
	private Socket s;

	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}

	public void run() {
		
		BufferedWriter socketBW;
		BufferedReader systemInBR;
		try {
			socketBW = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

			systemInBR = new BufferedReader(new InputStreamReader(System.in));

			String line = null;
			while ((line = systemInBR.readLine()) != null) {
				if (line.equals("over"))
					break;
				socketBW.write(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
