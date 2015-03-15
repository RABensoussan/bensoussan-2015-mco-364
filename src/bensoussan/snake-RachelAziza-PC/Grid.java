package bensoussan.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;

public class Grid extends JComponent {

	private static final long serialVersionUID = 1L;
	private final int cellsInGrid;
	private String direction;
	private Snake snake;
	private Point food;
	private Random rand;

	public Grid(int width, int height) {
		setSize(width, height);
		cellsInGrid = 25;
		rand = new Random();
		Point head = new Point(rand.nextInt(cellsInGrid),
				rand.nextInt(cellsInGrid - 3)); // give room for three points
												// underneath the head
		snake = new Snake(head);
		food = new Point(rand.nextInt(cellsInGrid), rand.nextInt(cellsInGrid));
		direction = "UP";
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth() / cellsInGrid;
		int h = getHeight() / cellsInGrid;

		paintGrid(g, w, h);

		drawFood(g, w, h);

		checkDirection();

		paintSnake(g, w, h);

	}

	private void drawFood(Graphics g, int w, int h) {
		if (food.equals(snake.getHead())) {
			snake.eatFood();
			food = new Point(rand.nextInt(cellsInGrid), rand.nextInt(cellsInGrid));
		}
		g.setColor(Color.RED);
		g.fillOval(w * food.getX(), h * food.getY(), w, h);
	}

	private void paintGrid(Graphics g, int w, int h) {
		for (int i = 0; i < cellsInGrid; i++) {
			for (int j = 0; j < cellsInGrid; j++) {
				g.setColor(Color.GRAY);
				g.fillRect(w * i, h * j, w, h);
			}
		}
	}

	private void paintSnake(Graphics g, int w, int h) {
		LinkedList<Point> snakeList = snake.getSnake();
		Iterator<Point> iter = snakeList.iterator();
		while (iter.hasNext()) {
			Point temp = iter.next();
			g.setColor(Color.BLACK);
			g.fillRect(w * temp.getX(), h * temp.getY(), w, h);
		}
	}

	private void checkDirection() {
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
