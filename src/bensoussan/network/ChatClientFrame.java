package bensoussan.network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea typedChats;
	private String incomingChat;
	private PrintWriter writer;

	public ChatClientFrame() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Client Chat");
		setSize(600, 400);

		Socket socket = null;
		try {
			socket = new Socket("localhost", 1234);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			writer = new PrintWriter(out, true);
			Thread t = new Thread() {
				public void run() {

					while (true) {
						try {
							incomingChat = reader.readLine();
							typedChats.append("You: " + incomingChat + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();

		} catch (Exception e) {
		}

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Container southContainer = new Container();
		southContainer.setLayout(new BorderLayout());

		typedChats = new JTextArea();
		typedChats.setMargin(new Insets(5, 5, 5, 5));
		typedChats.setLineWrap(true);
		JButton enterButton = new JButton("Enter");
		JTextField inChats = new JTextField();

		enterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chat = inChats.getText();
				inChats.setText(null);
				typedChats.setFont(new Font("Arial", 12, Font.PLAIN));
				typedChats.append("Me: ");
				typedChats.setFont(new Font("Comic Sans MS", 12, Font.BOLD));
				typedChats.append(chat + "\n");
				writer.println(chat);
			}
		});

		southContainer.add(inChats, BorderLayout.CENTER);
		southContainer.add(enterButton, BorderLayout.EAST);
		contentPane.add(typedChats, BorderLayout.CENTER);
		contentPane.add(southContainer, BorderLayout.SOUTH);

	}

	public static void main(String args[]) {
		
		ChatServerFrame server = new ChatServerFrame();
		server.setVisible(true);
		ChatClientFrame client = new ChatClientFrame();
		client.setVisible(true);

	}

}
