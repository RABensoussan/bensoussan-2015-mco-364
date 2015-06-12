package bensoussan.multichat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread implements Connector {

	private ArrayList<Socket> sockets;
	private ArrayList<PrintWriter> writers;
	private LinkedBlockingQueue<String> incomingChats;

	public Server() {

		sockets = new ArrayList<Socket>();
		writers = new ArrayList<PrintWriter>();
		incomingChats = new LinkedBlockingQueue<String>();
		new IncomingChatsThread(incomingChats, writers).start();

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

		incomingChats.add(line);

	}

}
