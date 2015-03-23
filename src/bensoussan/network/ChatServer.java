package bensoussan.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private String line;

	public ChatServer() {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			while (true) {
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getLine(){
		String temp = line;
		line = "";
		return temp;
	}
	
}
