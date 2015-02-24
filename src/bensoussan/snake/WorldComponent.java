package bensoussan.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private World world;
	private int sizeOfGrid;
	private boolean gameOver;

	public WorldComponent(int w, int h, int sizeOfGrid) {
		gameOver = false;
		this.sizeOfGrid = sizeOfGrid;
		world = new World(w, h, this.sizeOfGrid);
	}

	@Override
	protected void paintComponent(Graphics g) {
		world.paint(g);
		if (gameOver) {
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Britannic Bold", Font.BOLD, 100));
			g.drawString("GAME", 120, 200);
			g.drawString("OVER", 120, 300);
			g.setFont(new Font("Calibri", Font.BOLD, 20));
			g.drawString("You bump, you die.", 170, 330);
			g.drawString("Better luck next time!", 160, 350);
		}
	}

	public World getWorld() {
		return world;
	}

	public void gameOver() {
		gameOver = true;
	}

}
