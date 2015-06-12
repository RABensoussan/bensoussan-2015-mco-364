package bensoussan.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderThread extends Thread {

	private Connector connector;
	private Socket clientSocket;

	public ReaderThread(Connector connector, Socket clientSocket) {
		this.connector = connector;
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {

		try {
			InputStream in = clientSocket.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				connector.receivedText(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
