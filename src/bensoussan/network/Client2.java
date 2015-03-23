package bensoussan.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String args[]) {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 2002);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("Client 2 is working!");
			writer.flush();
			Thread.sleep(10 * 1000);
			writer.println("Wowee Client 2!");
			writer.flush();
			socket.close();
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} catch (InterruptedException e) {
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

}
