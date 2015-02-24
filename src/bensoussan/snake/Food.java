package bensoussan.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {

	private int x;
	private int y;

	public Food(int sizeOfGrid) {
		Random rand = new Random();
		x = rand.nextInt(sizeOfGrid);
		y = rand.nextInt(sizeOfGrid);
	}

	public Graphics paint(Graphics g, int w, int h) {
		g.setColor(Color.RED);
		g.fillOval(x * w, y * h, w, h);
		return g;
	}

	public Point getPoint() {
		return new Point(x, y);
	}

}
