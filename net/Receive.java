package net;
import java.io.*;
import java.net.*;

public class Receive {
	private String srcIp;
	private int desPort;
	private String data;
	
	public String getSrcIp() {
		return srcIp;
	}
	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public int getDesPort() {
		return desPort;
	}
	public void setDesPort(int desPort) {
		this.desPort = desPort;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	Receive(int desPort){
		this.desPort = desPort;
	}
	
	public void receiveData(int dataLength) throws IOException {
		DatagramSocket ds = new DatagramSocket(desPort);
		byte[] b = new byte[dataLength];
		DatagramPacket dp = new DatagramPacket(b, b.length);
		
		ds.receive(dp);
		
		srcIp = dp.getAddress().getHostAddress();
		data = new String(dp.getData(), 0, dp.getData().length);
		
		ds.close();
	}
}
