package bensoussan.multichat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread implements Connector {

	private ArrayList<Socket> sockets;
	private ArrayList<PrintWriter> writers;

	public Server() {

		sockets = new ArrayList<Socket>();
		writers = new ArrayList<PrintWriter>();

	}

	@Override
	public void run() {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(2002);

			while (true) {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				writers.add(new PrintWriter(socket.getOutputStream()));
				new ReaderThread(this, socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void receivedText(String line) {
		for (PrintWriter writer : writers) {
			writer.println(line);
			writer.flush();
			System.out.println("Server wrote the chat: " + line);
		}

	}

}
