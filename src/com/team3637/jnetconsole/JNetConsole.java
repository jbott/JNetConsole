package com.team3637.jnetconsole;
import com.team3637.jnetconsole.util.NetConsoleReceiverThread;
import java.net.SocketException;

public class JNetConsole {

	private static NetConsoleReceiverThread receiverThread;
	public static void main(String[] args) {
		System.out.println("JNetConsole!");
		try {
			receiverThread = new NetConsoleReceiverThread();
		} catch (SocketException e) {
			System.out.println("Socket failed to connect!");
			System.exit(0);
		}
		receiverThread.start();
	}
}
