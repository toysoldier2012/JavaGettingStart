package net;
import java.io.*;
import java.net.*;

public class Receive {
	private String srcIp;
	private int desPort;
	private boolean connect;
	
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

	public boolean isConnect() {
		return connect;
	}
	public void setConnect(boolean connect) {
		this.connect = connect;
	}
	
	Receive(){
	}
	Receive(int desPort){
		this.desPort = desPort;
	}
	
	public void receiveData(String data) throws IOException {
		DatagramSocket ds = new DatagramSocket(desPort);
		while(connect) {
			byte[] b = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			
			ds.receive(dp);
			
			srcIp = dp.getAddress().getHostAddress();
			data = new String(dp.getData(), 0, dp.getData().length);
		}
		
		ds.close();
	}
}
