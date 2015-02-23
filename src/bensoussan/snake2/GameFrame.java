package bensoussan.snake2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private WorldComponent comp;
	private int sizeOfGrid;

	public GameFrame() {

		setSize(517, 540);
		setBackground(Color.BLACK);
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		sizeOfGrid = 20;

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		comp = new WorldComponent(25, 25, sizeOfGrid);
		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);
	}

	public WorldComponent getComp() {
		return comp;
	}

	public static void main(String args[]) {
		GameFrame SNAKE = new GameFrame();
		SNAKE.setVisible(true);
		Thread t = new Thread() {
			public void run() {
				while (true) {
					SNAKE.getComp().getWorld().move();
					if (SNAKE.getComp().getWorld().didYouLose()) {
						break;
					}
					SNAKE.repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t.start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		comp.getWorld().setKeyCode(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
