package bensoussan.multichat;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class IncomingChatsThread extends Thread {

	private ArrayList<PrintWriter> writers;
	private LinkedBlockingQueue<String> incomingChats;

	public IncomingChatsThread(LinkedBlockingQueue<String> incomingChats,
			ArrayList<PrintWriter> writers) {
		this.incomingChats = incomingChats;
		this.writers = writers;
	}

	@Override
	public void run() {
		while (true) {
			String line;
			try {
				line = incomingChats.take();
				for (PrintWriter writer : writers) {
					writer.println(line);
					writer.flush();
					System.out.println("Server wrote the chat: " + line);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
