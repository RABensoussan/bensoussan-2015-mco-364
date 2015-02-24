package bensoussan.snake;

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

	// private Timer timer;
	// private JLabel time;

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
		contentPane.add(comp, BorderLayout.CENTER);

		/*
		 * Container northCont = new Container(); northCont.setLayout(new
		 * BorderLayout()); northCont.setBackground(Color.ORANGE); JLabel
		 * snakeTitle = new JLabel("Snake"); snakeTitle.setFont(new
		 * Font("Britannic Bold", Font.PLAIN, 20)); northCont.add(snakeTitle,
		 * BorderLayout.CENTER); timer = new Timer(); time = new
		 * JLabel(timer.toString()); northCont.add(time, BorderLayout.EAST);
		 * contentPane.add(northCont, BorderLayout.NORTH);
		 */
	}

	public WorldComponent getComp() {
		return comp;
	}

	public static void main(String args[]) {
		GameFrame SNAKE = new GameFrame();
		SNAKE.setVisible(true);
		Thread t = new Thread() {
			public void run() {
				int timer = 800;
				while (true) {
					if (SNAKE.getComp().getWorld().lostGame()) {
						SNAKE.getComp().gameOver();
						SNAKE.repaint();
						break;
					}
					SNAKE.getComp().getWorld().move();
					SNAKE.repaint();
					try {
						if (timer > 300) {
							timer -= 5;
						}
						Thread.sleep(timer);
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
