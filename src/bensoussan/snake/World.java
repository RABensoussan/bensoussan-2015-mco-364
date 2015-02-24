package bensoussan.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class World {

	private Snake snake;
	private Food food;
	private int keyCode;
	private int w;
	private int h;
	private int sizeOfGrid;
	private boolean permitToReset;

	public World(int w, int h, int sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		this.w = w;
		this.h = h;
		snake = new Snake(sizeOfGrid);
		do {
			food = new Food(sizeOfGrid);
		} while (foodOnSnake());
		keyCode = KeyEvent.VK_UP;
	}

	public void move() {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			snake.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			snake.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			snake.moveRight();
			break;
		}
		permitToReset = true;

		if (snake.getHead().equals(food.getPoint())) {
			snake.eat();
			do {
				food = new Food(sizeOfGrid);
			} while (foodOnSnake());
		}
	}

	private boolean foodOnSnake() {
		Iterator<Point> iter = snake.iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(food)) {
				return true;
			}
		}
		return false;
	}

	public boolean lostGame() {
		boolean bump = snake.bumped();
		boolean wall = snake.wall();
		if (bump || wall) {
			return true;
		}
		return false;
	}

	public void setKeyCode(int keyCode) {
		if (permitToReset) {
			if (this.keyCode == KeyEvent.VK_UP && keyCode == KeyEvent.VK_DOWN) {
				return;
			}
			if (this.keyCode == KeyEvent.VK_DOWN && keyCode == KeyEvent.VK_UP) {
				return;
			}
			if (this.keyCode == KeyEvent.VK_RIGHT
					&& keyCode == KeyEvent.VK_LEFT) {
				return;
			}
			if (this.keyCode == KeyEvent.VK_LEFT
					&& keyCode == KeyEvent.VK_RIGHT) {
				return;
			}

			this.keyCode = keyCode;
			permitToReset = false; // can only reset once between moves
		}
	}

	public Graphics paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, w * sizeOfGrid, h * sizeOfGrid);
		g = snake.paint(g, w, h);
		g = food.paint(g, w, h);
		return g;
	}

	public void gameOver() {

	}

}
