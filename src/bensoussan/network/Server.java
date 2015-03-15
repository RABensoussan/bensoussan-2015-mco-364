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
			serverSocket = new ServerSocket(3761);
			while (true) {
				Socket socket = serverSocket.accept();
				// InputStream reads in bytes
				InputStream in = socket.getInputStream();
				// wrap input stream in reader so can read String instead of
				// bytes
				// (can also wrap it in Scanner)
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				// read in a whole line
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
