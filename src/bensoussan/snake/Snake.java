package bensoussan.snake;

import java.awt.Graphics;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Random;

public class Snake {

	private Deque<Point> snake;
	private int sizeOfGrid;

	public Snake(int sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		Random rand = new Random();
		snake = new ArrayDeque<Point>();
		Point head = new Point(rand.nextInt(this.sizeOfGrid - 6) + 3,
				rand.nextInt(this.sizeOfGrid - 6) + 3);
		Point b = new Point(head.getX(), head.getY() + 1);
		Point c = new Point(head.getX(), head.getY() + 2);
		snake.addFirst(head);
		snake.addLast(b);
		snake.addLast(c);
	}

	public void moveUp() {
		snake.removeLast();
		Point currHead = snake.getFirst();
		snake.addFirst(new Point(currHead.getX(), currHead.getY() - 1));
	}

	public void moveDown() {
		snake.removeLast();
		Point currHead = snake.getFirst();
		snake.addFirst(new Point(currHead.getX(), currHead.getY() + 1));
	}

	public void moveRight() {
		snake.removeLast();
		Point currHead = snake.getFirst();
		snake.addFirst(new Point(currHead.getX() + 1, currHead.getY()));
	}

	public void moveLeft() {
		snake.removeLast();
		Point currHead = snake.getFirst();
		snake.addFirst(new Point(currHead.getX() - 1, currHead.getY()));
	}

	public void eat() {
		Point p = snake.getLast();
		snake.addLast(p);
	}

	public Graphics paint(Graphics g, int w, int h) {
		Iterator<Point> iter = snake.iterator();
		while (iter.hasNext()) {
			iter.next().drawPoint(g, w, h);
		}
		return g;
	}

	public boolean bumped() {
		Point head = snake.getFirst();
		Iterator<Point> iter = snake.iterator();
		iter.next();
		while (iter.hasNext()) {
			if (head.equals(iter.next())) {
				return true;
			}
		}
		return false;
	}

	public boolean wall() {
		Iterator<Point> iter = snake.iterator();
		while (iter.hasNext()) {
			Point p = iter.next();
			int x = p.getX();
			int y = p.getY();
			if (x < 0 || x > sizeOfGrid - 1 || y < 0 || y > sizeOfGrid - 1) {
				return true;
			}
		}
		return false;
	}

	public Point getHead() {
		return snake.getFirst();
	}

	public Iterator<Point> iterator() {
		return snake.iterator();
	}

}
