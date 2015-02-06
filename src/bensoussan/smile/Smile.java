package bensoussan.smile;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Smile extends JFrame {

	private static final long serialVersionUID = 1L;

	public Smile() {

		setSize(600, 600);
		setTitle("Smile! :)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(new SmileComponent());

	}

	public static void main(String args[]) {
		final Smile aSmile = new Smile();
		aSmile.setVisible(true);

		//animation thread - bec constantly calling repaint
		Thread t = new Thread() {
			public void run() {
				while (true) {
					aSmile.repaint();
					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};

		t.start();

	}

}