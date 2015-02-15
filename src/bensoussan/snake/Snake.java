package bensoussan.snake;

import java.util.LinkedList;

public class Snake {

	private Point head;
	private LinkedList<Point> snake;
	
	public Snake(Point head){
		this.head= head;
		snake = new LinkedList<Point>();
		generateSnake();
	}

	private void generateSnake() {
		snake.add(head);
		Point a = new Point(head.getX(), head.getY()-1);
		Point b = new Point(head.getX(), head.getY()-2);
		snake.add(a);
		snake.add(b);
		
	}

	public void moveUp(){
		
	}
	
	public void moveDown(){
		
	}
	
	public void moveRight(){
		
	}
	public void moveLeft(){
		
	}
	
	public Point getHead() {
		return head;
	}

	public LinkedList<Point> getSnake() {
		return snake;
	}

}
