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
			socket = new Socket("localhost", 2002);
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("This is Client 1.");
			writer.flush();
			Thread.sleep(10 * 1000);
			writer.println("Client 1 rocks.");
			writer.flush();
			socket.close();
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} catch (InterruptedException e) {
		} finally {
			/*try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
			}*/
			IOUtils.closeQuietly(socket);
		}
	}
}
