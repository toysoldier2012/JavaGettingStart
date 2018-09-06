package net.udp;

import java.io.*;
import java.net.*;

public class Receive {
	private String srcIp;
	private String srcName;
	private int desPort;
	private byte[] data = new byte[1024 * 8];

	public String getSrcIp() {
		return srcIp;
	}

	public String getSrcName() {
		return srcName;
	}

	public int getDesPort() {
		return desPort;
	}
	public void setDesPort(int desPort) {
		this.desPort = desPort;
	}

	public String getData() {
		return new String(data, 0, data.length);
	}

	Receive(int desPort){
		this.desPort = desPort;
	}
	
	public void rece() throws IOException {
		DatagramSocket ds = new DatagramSocket(desPort);
		DatagramPacket dp = new DatagramPacket(data, data.length);

		ds.receive(dp);
		
		srcIp = dp.getAddress().getHostAddress();
		srcName = dp.getAddress().getHostName();
		data = dp.getData();

		ds.close();
	}
}
