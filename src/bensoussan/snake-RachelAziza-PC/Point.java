package bensoussan.snake;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean equals(Point b) {
		if (this.x == b.getX() && this.y == b.getY()) {
			return true;
		} else {
			return false;
		}
	}

}
