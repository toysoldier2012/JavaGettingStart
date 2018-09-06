package net.udp;

import java.net.*;

public class PersonnelInfo {
	public static String getLocalName() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}
	
	public static String getLocalIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}
}
