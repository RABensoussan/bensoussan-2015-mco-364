package bensoussan.snake;

import java.util.LinkedList;

public class Snake {

	private Point head;
	private LinkedList<Point> snake;

	public Snake(Point head) {
		this.head = head;
		snake = new LinkedList<Point>();
		generateSnake();
	}

	private void generateSnake() {
		Point a = new Point(head.getX(), head.getY() - 1);
		Point b = new Point(head.getX(), head.getY() - 2);
		Point c = new Point(head.getX(), head.getY() - 3);
		snake.add(a);
		snake.add(b);
		snake.add(c);
		snake.add(head);
	}

	public void moveUp() {
		snake.remove();
		snake.add(new Point(head.getX(), head.getY() + 1));
	}

	public void moveDown() {
		snake.remove();
		snake.add(new Point(head.getX(), head.getY() - 1));
	}

	public void moveRight() {
		snake.remove();
		snake.add(new Point(head.getX() + 1, head.getY()));
	}

	public void moveLeft() {
		snake.remove();
		snake.add(new Point(head.getX() - 1, head.getY()));
	}

	public Point getHead() {
		return head;
	}

	public void eatFood() {
		Point p = snake.getFirst();
		snake.add(p);
	}

	public LinkedList<Point> getSnake() {
		return snake;
	}

}
