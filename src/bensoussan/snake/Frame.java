package bensoussan.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Frame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Grid grid;

	public Frame() {
		setSize(600, 600);
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		grid = new Grid();
		contentPane.add(grid);
		grid.addKeyListener(this);
		grid.setFocusable(true);

	}

	public static void main(String args[]) {
		Frame aFrame = new Frame();
		aFrame.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			grid.setDirection("UP");
			break;
		case KeyEvent.VK_DOWN:
			grid.setDirection("DOWN");
			break;
		case KeyEvent.VK_LEFT:
			grid.setDirection("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			grid.setDirection("RIGHT");
			break;
		}

	}
}
