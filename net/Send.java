package net;
import java.io.*;
import java.net.*;

public class Send {
	private String desIp;
	private int desPort;
	private byte[] data;
	
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

	Send(String desIp, int desPort, String data){
		this.desIp = desIp;
		this.desPort = desPort;
		this.data = data.getBytes();
	}
	
	public void sendData() throws IOException {
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dp = new DatagramPacket(
				data, data.length, InetAddress.getByName(desIp), desPort);
		ds.send(dp);
		ds.close();
	}
}
