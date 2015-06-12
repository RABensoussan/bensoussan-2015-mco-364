package bensoussan.multichat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Client client;
	private JTextArea inChats;
	private JTextField outChats;

	public ClientFrame(final String name) {
		outChats = new JTextField();
		inChats = new JTextArea("Chats go here");
		inChats.setEditable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name + "'s Chat");
		setSize(600, 400);

		client = new Client(inChats);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Container southContainer = new Container();
		southContainer.setLayout(new BorderLayout());

		outChats.setMargin(new Insets(5, 5, 5, 5));
		JButton enterButton = new JButton("Enter");

		enterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = outChats.getText();
				client.write(name + ": " + text);
				outChats.setText(null);
			}
		});

		JScrollPane scroll = new JScrollPane(inChats);
		add(scroll, BorderLayout.CENTER);
		southContainer.add(outChats, BorderLayout.CENTER);
		southContainer.add(enterButton, BorderLayout.EAST);
		contentPane.add(inChats, BorderLayout.CENTER);
		contentPane.add(southContainer, BorderLayout.SOUTH);

	}

}
