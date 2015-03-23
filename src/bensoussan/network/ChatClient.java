package bensoussan.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {

	private String line;

	public ChatClient() {
		Socket socket = null;
		try {
			socket = new Socket("192.168.1.11", 1211);
			InputStream in = socket.getInputStream();
			socket = new Socket("localhost", 1211);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			while (true) {
				line = reader.readLine();
			}
		} catch (Exception e) {
		}
	}

	public String getLine() {
		String temp = line;
		line = "";
		return temp;
	}
}
