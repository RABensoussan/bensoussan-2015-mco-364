package bensoussan.multichat;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class Client implements Connector {

	private JTextArea inChats;
	private PrintWriter writer;
	private String name;

	public Client(JTextArea inChats, String name) {
		this.inChats = inChats;
		this.name = name;

		try {
			Socket socket = new Socket("localhost", 2002);
			writer = new PrintWriter(socket.getOutputStream());
			new ReaderThread(this, socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void write(String text) {
		writer.println(text);
		writer.flush();
	}

	@Override
	public void receivedText(String text) {
		System.out.println(name + " received the chat: " + text);
		inChats.setFont(new Font("Arial", 12, Font.PLAIN));
		inChats.append("\n");
		inChats.append(text);
	}

}
