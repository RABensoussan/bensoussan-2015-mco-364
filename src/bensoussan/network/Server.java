package bensoussan.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(2002);
			while (true) {
				final Socket socket = serverSocket.accept();
				Thread t = new Thread() {
					public void run() {
						try {
							InputStream in = socket.getInputStream();
							BufferedReader reader = new BufferedReader(
									new InputStreamReader(in));
							String line;
							while ((line = reader.readLine()) != null) {
								System.out.println(line);
							}
						} catch (IOException e) {
						}
					}
				};
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
