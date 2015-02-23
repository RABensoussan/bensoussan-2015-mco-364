package bensoussan.snake2;

import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private World world;
	private int sizeOfGrid;

	public WorldComponent(int w, int h, int sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		world = new World(w, h, this.sizeOfGrid);
	}

	@Override
	protected void paintComponent(Graphics g) {
		world.paint(g);
	}

	public World getWorld() {
		return world;
	}

}
