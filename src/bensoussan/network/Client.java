package bensoussan.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String args[]) {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 3761);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("Do or do not, there is no try.");
			writer.flush();
			Thread.sleep(10 * 1000);
			writer.println("Alas, earwax.");
			writer.flush();
			Thread.sleep(10 * 1000);
			writer.print("To be or not to be, that is the question.");
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
