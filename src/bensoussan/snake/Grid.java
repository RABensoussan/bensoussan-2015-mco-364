package bensoussan.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

public class Grid extends JComponent {

	private static final long serialVersionUID = 1L;
	private final int SIZEOFGRID = 25;
	private String direction;
	private boolean eaten;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth() / SIZEOFGRID;
		int h = getHeight() / SIZEOFGRID;

		// paint background of GRID
		for (int i = 0; i < SIZEOFGRID; i++) {
			for (int j = 0; j < SIZEOFGRID; j++) {
				g.setColor(Color.GRAY);
				g.fillRect(w * i, h * j, w, h);
			}
		}

		// FOOD at random location
		Random rand = new Random();
		int foodX = rand.nextInt(SIZEOFGRID);
		int foodY = rand.nextInt(SIZEOFGRID);
		g.setColor(Color.RED);
		g.fillOval(w * foodX, h * foodY, w, h);

		// SNAKE!
		Point head = new Point(rand.nextInt(SIZEOFGRID),
				rand.nextInt(SIZEOFGRID - 2)); // give room for two points
												// underneath the head
		Snake snake = new Snake(head);
		switch (direction) {
		case "UP":
			snake.moveUp();
			break;
		case "DOWN":
			snake.moveDown();
			break;
		case "LEFT":
			snake.moveLeft();
			break;
		case "RIGHT":
			snake.moveRight();
			break;
		}

	}

	public void setDirection(String d) {
		direction = d;
	}

}
