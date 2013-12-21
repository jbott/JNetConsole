package com.team3637.jnetconsole.util;
import java.net.*;
import java.io.IOException;

public class NetConsoleReceiverThread extends Thread {
	private DatagramSocket socket;

	public NetConsoleReceiverThread() throws SocketException {
		socket = new DatagramSocket(6666); // Bind to socket on port 6666
	}

	public void run() {
		while(true) {
			try {
				byte[] buffer = new byte[8192];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				System.out.println(new String(packet.getData()).trim());
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}
		}
	}
}