package net;
import java.io.*;
import java.net.*;

public class Send implements Runnable{
	private String desIp;
	private int desPort;
	private byte[] data;
	private Exception e;
	
	public String getDesIp() {
		return desIp;
	}
	public void setDesIp(String desIp) {
		this.desIp = desIp;
	}

	public int getDesPort() {
		return desPort;
	}
	public void setDesPort(int desPort) {
		this.desPort = desPort;
	}
	
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public Exception getE() {
		return e;
	}
	
	public void run() {
		try {
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(
					data, data.length, InetAddress.getByName(desIp), desPort);
			ds.send(dp);
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.e = e;
		}
	}
}
