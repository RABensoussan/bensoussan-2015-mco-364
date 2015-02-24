package bensoussan.snake;

import java.awt.Color;
import java.awt.Graphics;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean equals(Point b) {
		if (x == b.getX() && y == b.getY()) {
			return true;
		} else {
			return false;
		}
	}

	public Graphics drawPoint(Graphics g, int w, int h) {
		g.setColor(Color.GREEN);
		g.fillRect(x * w, y * h, w, h);
		return g;
	}

}
