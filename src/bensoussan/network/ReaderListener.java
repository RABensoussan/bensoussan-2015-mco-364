package bensoussan.network;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead(String line);

	void onCloseSocket(Socket socket);
	
}